package com.relaciones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relaciones.entidades.Autor;
import com.relaciones.entidades.Libro;
import com.relaciones.repositorio.AutorRepositorio;

@Service
public class AutorServicioImpl implements AutorServicio {

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Override
    public List<Autor> listarTodos() {
        return autorRepositorio.findAll();
    }

    @Override
    public Autor obtenerPorId(Long id) {
        return autorRepositorio.findById(id)
            .orElseThrow(() -> new RuntimeException("Autor no encontrado")); // Considera lanzar una excepción más específica
    }

    @Override
    public Autor guardarautor(Autor autor) {
        // Validaciones adicionales pueden ser necesarias aquí
        return autorRepositorio.save(autor);
    }

    @Override
    public Autor actualizarautor(Autor autor) {
        // Validaciones adicionales pueden ser necesarias aquí
        return autorRepositorio.save(autor);
    }

    @Override
    public void eliminarautor(Long id) {
        autorRepositorio.deleteById(id);
    }

    @Override
    public Autor buscarPorNombre(String nombre) {
        return autorRepositorio.findByNombreIgnoreCase(nombre).orElse(null); // Devuelve null si no se encuentra
    }
 

}
