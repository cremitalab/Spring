package com.relaciones.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relaciones.entidades.Autor;
import com.relaciones.entidades.Libro;
import com.relaciones.repositorio.AutorRepositorio;
import com.relaciones.repositorio.LibroRepositorio;

@Service
public class LibroServicioImpl implements LibroService {

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private AutorRepositorio autorRepositorio; // Corregido el nombre

    @Override
    public List<Libro> listarTodos() {
        return libroRepositorio.findAll();
    }

    @Override
    public Libro obtenerPorId(Long id) {
        Optional<Libro> libro = libroRepositorio.findById(id);
        return libro.orElse(null);
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    @Override
    public Libro actualizarLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    @Override
    public void eliminarLibro(Long id) {
        libroRepositorio.deleteById(id);
    }

    @Override
    public Autor buscarPorNombre(String nombre) {
        return autorRepositorio.findByNombreIgnoreCase(nombre).orElse(null); // Devuelve null si no se encuentra
    }
    @Override
    public List<Libro> buscarPorNombreAutor(String nombreAutor) {
        return libroRepositorio.buscarPorNombreAutor(nombreAutor);
    }
    @Override
    public List<Libro> obtenerTodosLosLibros() {
        return libroRepositorio.findAll();
    }
}
