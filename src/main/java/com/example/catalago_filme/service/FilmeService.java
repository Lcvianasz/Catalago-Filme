package com.example.catalago_filme.service;

import com.example.catalago_filme.repository.FilmeRepository;
import com.example.catalago_filme.model.Filme;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public Filme salvar(Filme filme){
        return filmeRepository.save(filme);
    }
    public List<Filme> listarTodos(){
        return filmeRepository.findAll();
    }
}
