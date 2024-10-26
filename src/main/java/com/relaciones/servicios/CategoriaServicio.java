package com.relaciones.servicios;

import java.util.List;

import com.relaciones.entidades.Categoria;

public interface CategoriaServicio {
    List<Categoria> listarTodos();
    Categoria obtenerPorId(Long id);
    Categoria guardarcategoria(Categoria categoria);
    Categoria actualizarcategoria(Categoria categoria);
    void eliminarcategoria(Long id);
}
