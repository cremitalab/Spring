package com.relaciones.servicios;

import java.util.List;

import com.relaciones.entidades.Autor;
import com.relaciones.entidades.Libro;

public interface LibroService {
    List<Libro> listarTodos();
    
    Libro guardarLibro(Libro libro); // Corrige el nombre del método
    Libro actualizarLibro(Libro libro); // Corrige el nombre del método

    Libro obtenerPorId(Long id);
    
    void eliminarLibro(Long id);
    List<Libro> buscarPorNombreAutor(String nombreAutor);
    List<Libro> obtenerTodosLosLibros(); // Método corregido para obtener todos los libros
    Autor buscarPorNombre(String nombre); // Método agregado
}
