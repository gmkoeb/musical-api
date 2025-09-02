package com.utfpr.musical_api.backend_musical_api.service;

import com.utfpr.musical_api.backend_musical_api.entity.Categoria;
import com.utfpr.musical_api.backend_musical_api.entity.Musica;
import com.utfpr.musical_api.backend_musical_api.exceptions.CategoriaExistsException;
import com.utfpr.musical_api.backend_musical_api.repository.CategoriaRepository;
import com.utfpr.musical_api.backend_musical_api.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void salvar(Musica musica, Categoria categoria) throws CategoriaExistsException {
        if (categoriaRepository.findById(categoria.getId()).isEmpty()) {
            categoriaRepository.save(categoria);
        }
        musica.setCategoria(categoria);
        repository.save(musica);
    }

    public List<Musica> listar(){
        return repository.findAll();
    }

    public void remover(Musica musica){
        repository.delete(musica);
    }
}
