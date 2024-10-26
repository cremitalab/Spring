package com.relaciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.relaciones.entidades.Autor;
import com.relaciones.servicios.AutorServicio;

import java.util.List;

@Controller
@RequestMapping("/autor")
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;

    // Listar todos los autores
    @GetMapping
    public String listarAutores(Model model) {
        List<Autor> autores = autorServicio.listarTodos();
        model.addAttribute("autores", autores);
        model.addAttribute("nuevoautor", new Autor());
        return "autor"; // Vista autor.html
    }

    // Guardar un nuevo autor
    @PostMapping("/guardar")
    public String guardarAutor(@ModelAttribute("nuevoautor") Autor autor) {
        autorServicio.guardarautor(autor);
        return "redirect:/autor";
    }

    // Editar un autor
    @GetMapping("/editar/{id}")
    public String editarAutor(@PathVariable("id") Long id, Model model) {
        Autor autor = autorServicio.obtenerPorId(id);
        model.addAttribute("nuevoautor", autor);
        return "autor"; // Retorna la misma vista con el autor cargado
    }

    // Actualizar un autor
    @PostMapping("/actualizar/{id}")
    public String actualizarAutor(@PathVariable("id") Long id, @ModelAttribute("nuevoautor") Autor autor) {
        autor.setId(id); // Asegúrate de que el id se establece antes de actualizar
        autorServicio.actualizarautor(autor);
        return "redirect:/autor";
    }

    // Eliminar un autor
    @GetMapping("/eliminar/{id}")
    public String eliminarAutor(@PathVariable("id") Long id) {
        autorServicio.eliminarautor(id);
        return "redirect:/autor";
    }

    // Buscar autor por nombre (nuevo método)
    @PostMapping("/buscar")
    public String buscarAutorPorNombre(@RequestParam("nombre") String nombre, Model model) {
        try {
            Autor autor = autorServicio.buscarPorNombre(nombre);
            model.addAttribute("autores", List.of(autor)); // Añade el autor encontrado a la lista
            model.addAttribute("nuevoautor", new Autor());
        } catch (RuntimeException e) {
            model.addAttribute("mensaje", e.getMessage());
            model.addAttribute("autores", autorServicio.listarTodos()); // Listar todos si no se encuentra
        }
        return "autor"; // Regresar a la vista
    }
}
