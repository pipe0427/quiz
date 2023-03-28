package com.quiz.categoria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.quiz.categoria.entity.Categoria;
import com.quiz.categoria.service.CategoriaService;

@Controller
public class CategoriaController {
    
    @Autowired
    private CategoriaService servicio;

    @GetMapping({"/categorias","/"})
    public String listarCategoria(Model model){
        model.addAttribute("categorias", servicio.listarCategoria());
        return "categorias";
    }

    @GetMapping("/categorias/nuevo")
    public String mostrarFormularioDeRegistrarcategoria(Model model){
        Categoria categoria = new Categoria();
        model.addAttribute("categoria",categoria);
        return "crear_categoria";
    }

    @PostMapping("/categorias")
    public String guardarEmpleado(@ModelAttribute("categoria") Categoria categoria) {
        servicio.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/editar/{codigo}")
    public String mostrarFormularioDeEditar(@PathVariable Long codigo, Model modelo) {
        modelo.addAttribute("categoria", servicio.obtenerCategoriaPorCodigo(codigo));
        return "editar_categoria";
    }

    @PostMapping("/categorias/{codigo}")
    public String actualizarEstudiante(@PathVariable Long codigo, @ModelAttribute("categoria") Categoria categoria,Model modelo) {
        Categoria categoriaExistente = servicio.obtenerCategoriaPorCodigo(codigo);
        categoriaExistente.setCodigo(categoria.getCodigo());
        categoriaExistente.setNombreProducto(categoria.getNombreProducto());
        categoriaExistente.setDescripcion(categoria.getDescripcion());
        
        servicio.actualizarCategoria(categoriaExistente);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/{codigo}")
    public String eliminarCategoria(@PathVariable Long codigo) {
        servicio.eliminarCategoria(codigo);
        return "redirect:/categorias";
    }
}
