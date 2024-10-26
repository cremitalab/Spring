package com.relaciones.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.relaciones.entidades.Cliente;
import com.relaciones.servicios.ClienteServicio;



@Controller
@RequestMapping("/cliente")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    // Mostrar la página con la lista de estudiantes
    @GetMapping
    public String listarcliente(Model model) {
        List<Cliente> cliente = clienteServicio.listarTodos();
        model.addAttribute("clientes", cliente);
        model.addAttribute("nuevoCliente", new Cliente()); // Para el formulario de creación
        return "cliente"; // Llamar a la plantilla estudiantes.html
    }

    // Crear o actualizar un estudiante
    @PostMapping("/guardar")
    public String guardarcliente(@ModelAttribute("nuevoCliente") Cliente cliente) {
    	clienteServicio.guardarcliente(cliente);
        return "redirect:/cliente";
    }

    // Eliminar un estudiante
    @GetMapping("/eliminar/{id}")
    public String eliminarcliente(@PathVariable("id") Long id) {
    	clienteServicio.eliminarcliente(id);
        return "redirect:/cliente";
    }

    // Cargar el estudiante para editar
    @GetMapping("/editar/{id}")
    public String editarcliente(@PathVariable("id") Long id, Model model) {
    	Cliente cliente = clienteServicio.obtenerPorId(id);
    	 model.addAttribute("nuevoCliente", cliente); // Llenar el formulario con los datos del estudiante
        return "cliente";
    }
}
