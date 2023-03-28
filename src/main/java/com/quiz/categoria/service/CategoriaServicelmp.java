package com.quiz.categoria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.categoria.entity.Categoria;
import com.quiz.categoria.repositorio.ICategoriaRepositorio;

@Service
public class CategoriaServicelmp implements CategoriaService {
    
    @Autowired
    private ICategoriaRepositorio repositorio;

    @Override
    public List<Categoria> listarCategoria() {

        return repositorio.findAll();
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {

        return repositorio.save(categoria);
    }

    @Override
    public Categoria obtenerCategoriaPorCodigo(Long codigo) {

        return repositorio.findById(codigo).get();
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        return repositorio.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        repositorio.deleteById(id);

    }
}
