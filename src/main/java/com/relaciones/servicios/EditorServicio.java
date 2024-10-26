package com.relaciones.servicios;

import java.util.List;

import com.relaciones.entidades.Editor;

public interface EditorServicio {

	List<Editor> listarTodos();
	Editor obtenerPorId(Long id);
	Editor guardareditor(Editor editor);
	Editor actualizareditor(Editor editor);
    void eliminareditor(Long id);
}
