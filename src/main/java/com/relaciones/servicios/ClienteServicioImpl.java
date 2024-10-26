package com.relaciones.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relaciones.entidades.Cliente;
import com.relaciones.repositorio.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente obtenerPorId(Long id) {
        Optional<Cliente> cliente = clienteRepositorio.findById(id);
        return cliente.orElse(null);
    }

    @Override
    public Cliente guardarcliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente actualizarcliente(Cliente cliente) {
        return clienteRepositorio.save(cliente); // Save sirve tanto para insertar como para actualizar
    }

    @Override
    public void eliminarcliente(Long id) {
    	clienteRepositorio.deleteById(id);
    }
}