package com.relaciones.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relaciones.entidades.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
