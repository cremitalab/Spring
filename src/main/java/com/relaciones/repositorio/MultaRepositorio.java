package com.relaciones.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relaciones.entidades.Multa;

public interface MultaRepositorio extends JpaRepository<Multa, Long> {

}
