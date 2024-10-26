package com.relaciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.relaciones.entidades.Editor;
import com.relaciones.servicios.EditorServicio;

import java.util.List;

@Controller
@RequestMapping("/editor")
public class EditorControlador {

    @Autowired
    private EditorServicio editorServicio;

    // Listar todos los editores
    @GetMapping
    public String listarEditores(Model model) {
        List<Editor> editores = editorServicio.listarTodos();
        model.addAttribute("editores", editores);
        model.addAttribute("nuevoeditor", new Editor());
        return "editor"; // Vista editor.html
    }

    // Guardar un nuevo editor
    @PostMapping("/guardar")
    public String guardarEditor(@ModelAttribute("nuevoeditor") Editor editor) {
        editorServicio.guardareditor(editor);
        return "redirect:/editor";
    }

    // Editar un editor
    @GetMapping("/editar/{id}")
    public String editarEditor(@PathVariable("id") Long id, Model model) {
        Editor editor = editorServicio.obtenerPorId(id);
        model.addAttribute("nuevoeditor", editor);
        return "editor"; // Retorna la misma vista con el editor cargado
    }

    // Actualizar un editor
    @PostMapping("/actualizar/{id}")
    public String actualizarEditor(@PathVariable("id") Long id, @ModelAttribute("nuevoeditor") Editor editor) {
        editor.setId(id);
        editorServicio.actualizareditor(editor);
        return "redirect:/editor";
    }

    // Eliminar un editor
    @GetMapping("/eliminar/{id}")
    public String eliminarEditor(@PathVariable("id") Long id) {
        editorServicio.eliminareditor(id);
        return "redirect:/editor";
    }
}
