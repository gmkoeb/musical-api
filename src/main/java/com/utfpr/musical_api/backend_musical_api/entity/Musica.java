package com.utfpr.musical_api.backend_musical_api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "musicas")
@Data
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_musica", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_categoria", nullable = false)
    private Categoria categoria;

    @Column(length = 100)
    private String titulo;

    private Integer duracao;
}
