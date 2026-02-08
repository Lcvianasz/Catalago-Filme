package com.example.catalago_filme.service;

import com.example.catalago_filme.dto.FilmeGeneroDTO;
import com.example.catalago_filme.dto.FilmeRequestDTO;
import com.example.catalago_filme.dto.FilmeResponseDTO;
import com.example.catalago_filme.dto.GeneroDTO;
import com.example.catalago_filme.mapper.FilmeMapper;
import com.example.catalago_filme.model.Filme;
import com.example.catalago_filme.model.Genero;
import com.example.catalago_filme.repository.FilmeRepository;
import com.example.catalago_filme.repository.GeneroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final GeneroRepository generoRepository;

    // ✅ CRIAR FILME
    public FilmeResponseDTO criar(FilmeRequestDTO dto) {

        Filme filme = Filme.builder()
                .titulo(dto.getTitulo())
                .anoLancamento(dto.getAnoLancamento())
                .build();

        Filme salvo = filmeRepository.save(filme);

        return FilmeResponseDTO.builder()
                .id(salvo.getId())
                .titulo(salvo.getTitulo())
                .anoLancamento(salvo.getAnoLancamento())
                .generos(Set.of())
                .build();
    }

    // ✅ ADICIONAR GÊNEROS AO FILME
    public FilmeResponseDTO adicionarGeneros(Long filmeId, FilmeGeneroDTO dto) {

        if (dto.getGenerosIds() == null || dto.getGenerosIds().isEmpty()) {
            throw new IllegalArgumentException("Lista de gêneros não pode ser vazia");
        }

        Filme filme = filmeRepository.findById(filmeId)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        Set<Genero> generos = generoRepository
                .findAllById(dto.getGenerosIds())
                .stream()
                .collect(Collectors.toSet());

        filme.getGeneros().addAll(generos);

        Filme atualizado = filmeRepository.save(filme);

        return FilmeResponseDTO.builder()
                .id(atualizado.getId())
                .titulo(atualizado.getTitulo())
                .anoLancamento(atualizado.getAnoLancamento())
                .generos(
                        atualizado.getGeneros().stream()
                                .map(g -> new GeneroDTO(g.getId(), g.getNome()))
                                .collect(Collectors.toSet())
                )
                .build();
    }

    // ✅ LISTAR FILMES
    public List<FilmeResponseDTO> listar() {
        return filmeRepository.findAll()
                .stream()
                .map(FilmeMapper::toResponse)
                .collect(Collectors.toList());
    }
}