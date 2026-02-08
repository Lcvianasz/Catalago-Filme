package com.example.catalago_filme.dto;

import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FilmeResponseDTO {
    private Long id;
    private String titulo;
    private Integer anoLancamento;
    private Set<GeneroDTO> generos;
}
