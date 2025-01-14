package com.analistas.agenda.model.service;

import java.util.List;

import com.analistas.agenda.model.orm.Cliente;

public interface IClienteService {

    public List<Cliente> buscarTodo();

    public List<Cliente> buscarPor(String criterio);    

    public Cliente buscarPorId(Long id);

    public void guardar(Cliente cliente);

}
