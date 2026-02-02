package com.example.catalago_filme.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "generos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "generos")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Filme> filmes = new HashSet<>();

}
