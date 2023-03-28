package com.quiz.categoria.service;

import java.util.List;


import com.quiz.categoria.entity.Categoria;


public interface CategoriaService  {
    
    public List<Categoria> listarCategoria();

    public Categoria guardarCategoria(Categoria categoria);

    public Categoria obtenerCategoriaPorCodigo (Long codigo);

    public Categoria actualizarCategoria(Categoria categoria);

    public void eliminarCategoria(Long id);
}
