package com.analistas.agenda.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.analistas.agenda.model.orm.Categoria;

public interface ICategoriaRepository extends CrudRepository<Categoria, Long> {

}
