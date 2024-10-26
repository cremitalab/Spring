package com.relaciones.servicios;

import java.util.List;

import com.relaciones.entidades.Cliente;

public interface ClienteServicio {

	List<Cliente> listarTodos();
	Cliente obtenerPorId(Long id);
	Cliente guardarcliente(Cliente cliente);
	Cliente actualizarcliente(Cliente cliente);
    void eliminarcliente(Long id);
}
