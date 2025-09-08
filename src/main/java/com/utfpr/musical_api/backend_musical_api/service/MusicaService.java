package com.utfpr.musical_api.backend_musical_api.service;

import com.utfpr.musical_api.backend_musical_api.entity.Categoria;
import com.utfpr.musical_api.backend_musical_api.entity.Musica;
import com.utfpr.musical_api.backend_musical_api.exceptions.MusicaBusinessException;
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

    public void salvar(Musica musica, Categoria categoria) throws MusicaBusinessException {
        if (categoriaRepository.findByNome(categoria.getNome()).isEmpty()) {
            categoriaRepository.save(categoria);
        }

        if(repository.findByTitulo(musica.getTitulo()).isPresent()) {
            throw new MusicaBusinessException("Música com titulo: " + musica.getTitulo() + " já existe.",
                    MusicaBusinessException.Reason.TITLE_ALREADY_EXISTS);
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
