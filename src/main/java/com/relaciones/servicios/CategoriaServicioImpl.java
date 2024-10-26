package com.relaciones.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relaciones.entidades.Categoria;
import com.relaciones.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public List<Categoria> listarTodos() {
        return categoriaRepositorio.findAll();
    }

    @Override
    public Categoria obtenerPorId(Long id) {
        Optional<Categoria> categoria = categoriaRepositorio.findById(id);
        return categoria.orElse(null);
    }

    @Override
    public Categoria guardarcategoria(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }

    @Override
    public Categoria actualizarcategoria(Categoria categoria) {
        return categoriaRepositorio.save(categoria); // Save sirve tanto para insertar como para actualizar
    }

    @Override
    public void eliminarcategoria(Long id) {
    	categoriaRepositorio.deleteById(id);
    }
}