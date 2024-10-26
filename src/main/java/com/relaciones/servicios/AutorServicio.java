package com.relaciones.servicios;

import java.util.List;

import com.relaciones.entidades.Autor;

public interface AutorServicio {
    List<Autor> listarTodos();
    Autor obtenerPorId(Long id);
    Autor guardarautor(Autor autor);
    Autor actualizarautor(Autor autor);
    void eliminarautor(Long id);
    Autor buscarPorNombre(String nombre); // Método para buscar por nombre
}
