package com.relaciones.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relaciones.entidades.Prestamo;

public interface PrestamoRepositorio extends JpaRepository<Prestamo, Long>{

}
