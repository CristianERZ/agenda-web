package com.analistas.agenda.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.analistas.agenda.model.orm.Categoria;
import com.analistas.agenda.model.repository.ICategoriaRepository;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

    @Autowired
    ICategoriaRepository categoriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> buscarTodo() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> buscarPor(String criterio) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void guardar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

}

