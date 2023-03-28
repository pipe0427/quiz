package com.quiz.categoria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.categoria.entity.Categoria;

@Repository
public interface ICategoriaRepositorio  extends JpaRepository<Categoria, Long>{
    
}
