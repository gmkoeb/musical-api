package com.utfpr.musical_api.backend_musical_api.service;

import com.utfpr.musical_api.backend_musical_api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;
}
