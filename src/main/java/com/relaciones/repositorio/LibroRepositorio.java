package com.relaciones.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.relaciones.entidades.Libro;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {

	 @Query("SELECT l FROM Libro l WHERE LOWER(l.autor.nombre) LIKE LOWER(CONCAT('%', :nombreAutor, '%'))")
	    List<Libro> buscarPorNombreAutor(@Param("nombreAutor") String nombreAutor); }
