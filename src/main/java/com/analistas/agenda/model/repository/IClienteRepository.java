package com.analistas.agenda.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.analistas.agenda.model.orm.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Long> {

}
