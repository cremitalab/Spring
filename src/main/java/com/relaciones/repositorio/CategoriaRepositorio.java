package com.relaciones.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relaciones.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
