package com.relaciones.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relaciones.entidades.Autor;


public interface AutorRepositorio extends JpaRepository<Autor, Long>{
	 Optional<Autor> findByNombreIgnoreCase(String nombre); // Este método busca ignorando mayúsculas y minúsculas
}
