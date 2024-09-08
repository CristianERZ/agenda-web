package com.analistas.agenda.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.analistas.agenda.model.orm.Cliente;
import com.analistas.agenda.model.repository.IClienteRepository;

@Service
public class ClienteServiceimpl implements IClienteService{

    @Autowired
    IClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> buscarTodo() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> buscarPor(String criterio) {
       return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void guardar(Cliente cliente) {
       clienteRepository.save(cliente);
    }

}
