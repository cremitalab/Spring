package com.relaciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.relaciones.entidades.Libro;
import com.relaciones.entidades.Autor;
import com.relaciones.entidades.Editor;
import com.relaciones.entidades.Categoria;
import com.relaciones.servicios.LibroService;
import com.relaciones.servicios.AutorServicio;
import com.relaciones.servicios.EditorServicio;
import com.relaciones.servicios.CategoriaServicio;

@Controller
@RequestMapping("/libro")
public class LibroControlador {

    @Autowired
    private LibroService libroServicio;

    @Autowired
    private AutorServicio autorService;

    @Autowired
    private EditorServicio editorService;

    @Autowired
    private CategoriaServicio categoriaService;

    @GetMapping
    public String listarLibros(Model model) {
        List<Libro> libros = libroServicio.listarTodos();
        model.addAttribute("libros", libros);
        cargarDatosFormulario(model); // Método auxiliar para cargar datos necesarios
        model.addAttribute("nuevolibro", new Libro());
        return "libro"; // Asegúrate de que este nombre coincida con tu vista
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable("id") Long id) {
        libroServicio.eliminarLibro(id);
        return "redirect:/libro";
    }

    @GetMapping("/editar/{id}")
    public String editarLibro(@PathVariable("id") Long id, Model model) {
        Libro libro = libroServicio.obtenerPorId(id);
        model.addAttribute("nuevolibro", libro);
        cargarDatosFormulario(model); // Cargar datos para el formulario
        return "libro";
    }

    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro) {
        libroServicio.guardarLibro(libro);
        return "redirect:/libro"; // Redirigir a la lista de libros
    }

    @PostMapping("/buscar")
    public String buscarLibrosPorAutor(@RequestParam("nombreAutor") String nombreAutor, Model model) {
        List<Libro> librosEncontrados = libroServicio.buscarPorNombreAutor(nombreAutor);
        model.addAttribute("libros", librosEncontrados);
        model.addAttribute("nombreAutorBuscado", nombreAutor); // Cambiado para ser más claro

        if (librosEncontrados.isEmpty()) {
            model.addAttribute("mensaje", "No se encontraron libros para el autor: " + nombreAutor);
        }

        cargarDatosFormulario(model); // Cargar datos necesarios para el formulario
        return "libro"; 
    }

    private void cargarDatosFormulario(Model model) {
        // Cargar autores, editores y categorías
        List<Autor> autores = autorService.listarTodos();
        List<Editor> editores = editorService.listarTodos();
        List<Categoria> categorias = categoriaService.listarTodos();

        model.addAttribute("autores", autores);
        model.addAttribute("editores", editores);
        model.addAttribute("categorias", categorias);
    }
}
