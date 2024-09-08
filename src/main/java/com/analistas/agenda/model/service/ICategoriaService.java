package com.analistas.agenda.model.service;

import java.util.List;

import com.analistas.agenda.model.orm.Categoria;

public interface ICategoriaService {

    public List<Categoria> buscarTodo();

    public List<Categoria> buscarPor(String criterio);

    public Categoria buscarPorId(Long id);

    public void guardar(Categoria categoria);
}
