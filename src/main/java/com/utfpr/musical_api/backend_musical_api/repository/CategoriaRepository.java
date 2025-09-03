package com.utfpr.musical_api.backend_musical_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utfpr.musical_api.backend_musical_api.entity.Categoria;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    Optional<Categoria> findByNome(String nome);
}
