package com.relaciones.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.relaciones.entidades.Editor;

import com.relaciones.repositorio.EditorRepositorio;


@Service
public class EditorServicionImpl implements EditorServicio {

    @Autowired
    private EditorRepositorio editoRepositorio;

    @Override
    public List<Editor> listarTodos() {
        return editoRepositorio.findAll();
    }

    @Override
    public Editor obtenerPorId(Long id) {
        Optional<Editor> editor = editoRepositorio.findById(id);
        return editor.orElse(null);
    }

    @Override
    public Editor guardareditor(Editor editor) {
        return editoRepositorio.save(editor);
    }

    @Override
    public Editor actualizareditor(Editor editor) {
        return editoRepositorio.save(editor); // Save sirve tanto para insertar como para actualizar
    }

    @Override
    public void eliminareditor(Long id) {
    	editoRepositorio.deleteById(id);
    }
}