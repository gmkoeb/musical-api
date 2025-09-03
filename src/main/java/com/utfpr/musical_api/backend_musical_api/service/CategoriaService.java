package com.utfpr.musical_api.backend_musical_api.service;

import com.utfpr.musical_api.backend_musical_api.entity.Categoria;
import com.utfpr.musical_api.backend_musical_api.exceptions.CategoriaExistsException;
import com.utfpr.musical_api.backend_musical_api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public void salvar(Categoria categoria) throws CategoriaExistsException {
        if(repository.findByNome(categoria.getNome()).isPresent()) {
            throw new CategoriaExistsException("Categoria com nome: " +  categoria.getNome() + " já existe.");
        }
        repository.save(categoria);
    }

    public List<Categoria> listar(){
        return repository.findAll();
    }

    public void remover(Categoria categoria){
        repository.delete(categoria);
    }
}
