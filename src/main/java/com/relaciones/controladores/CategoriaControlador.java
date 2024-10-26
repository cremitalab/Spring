package com.relaciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.relaciones.entidades.Categoria;
import com.relaciones.servicios.CategoriaServicio;

import java.util.List;

@Controller
@RequestMapping("/categoria")
public class CategoriaControlador {

    @Autowired
    private CategoriaServicio categoriaServicio;

    // Listar todas las categorías
    @GetMapping
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaServicio.listarTodos();
        model.addAttribute("categorias", categorias);
        model.addAttribute("nuevacategoria", new Categoria());
        return "categoria"; // Vista categoria.html
    }

    // Guardar una nueva categoría
    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute("nuevacategoria") Categoria categoria) {
        categoriaServicio.guardarcategoria(categoria);
        return "redirect:/categoria";
    }

    // Editar una categoría
    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable("id") Long id, Model model) {
        Categoria categoria = categoriaServicio.obtenerPorId(id);
        model.addAttribute("nuevacategoria", categoria);
        return "categoria"; // Retorna la misma vista con la categoría cargada
    }

    // Actualizar una categoría
    @PostMapping("/actualizar/{id}")
    public String actualizarCategoria(@PathVariable("id") Long id, @ModelAttribute("nuevacategoria") Categoria categoria) {
        categoria.setId(id);
        categoriaServicio.actualizarcategoria(categoria);
        return "redirect:/categoria";
    }

    // Eliminar una categoría
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable("id") Long id) {
        categoriaServicio.eliminarcategoria(id);
        return "redirect:/categoria";
    }
}
