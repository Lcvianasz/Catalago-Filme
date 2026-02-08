package com.example.catalago_filme.mapper;

import com.example.catalago_filme.dto.FilmeResponseDTO;
import com.example.catalago_filme.dto.GeneroDTO;
import com.example.catalago_filme.model.Filme;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FilmeMapper {

    public static FilmeResponseDTO toResponse(Filme filme) {
        return FilmeResponseDTO.builder()
                .id(filme.getId())
                .titulo(filme.getTitulo())
                .anoLancamento(filme.getAnoLancamento())
                .generos(
                        filme.getGeneros().stream()
                                .map(g -> new GeneroDTO(
                                        g.getId(),
                                        g.getNome()
                                ))
                                .collect(Collectors.toSet())
                )
                .build();

        }
}
