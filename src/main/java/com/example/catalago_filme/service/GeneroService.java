package com.example.catalago_filme.service;

import com.example.catalago_filme.model.Genero;
import com.example.catalago_filme.repository.GeneroRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeneroService {

    private final GeneroRepository generoRepository;

    public List<Genero> listarTodos() {
        return generoRepository.findAll();
    }

    public Genero salvar(Genero genero){
        return generoRepository.save(genero);
    }

}
