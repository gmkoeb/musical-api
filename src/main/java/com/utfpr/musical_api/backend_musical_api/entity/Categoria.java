package com.utfpr.musical_api.backend_musical_api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categorias", uniqueConstraints = {
        @UniqueConstraint(columnNames = "nome_categoria")
})
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_categoria", nullable = false)
    private Long id;

    @Column(name = "nome_categoria", length = 50, unique = true, nullable = false)
    private String name;

    @Column(name = "desc_categoria", length = 250)
    private String descCategoria;
}
