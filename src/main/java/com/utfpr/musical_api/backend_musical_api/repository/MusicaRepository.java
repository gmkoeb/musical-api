package com.utfpr.musical_api.backend_musical_api.repository;

import com.utfpr.musical_api.backend_musical_api.entity.Categoria;
import com.utfpr.musical_api.backend_musical_api.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica,Long> {
    CharSequence findByCategoria(Categoria categoria);
}
