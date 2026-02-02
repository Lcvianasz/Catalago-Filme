package com.example.catalago_filme.controller;

import com.example.catalago_filme.model.Filme;
import com.example.catalago_filme.repository.FilmeRepository;
import com.example.catalago_filme.service.FilmeService;
import org.springframework.web.bind.annotation.*;
import lombok.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;

    @GetMapping
    public List<Filme> listar(){
        return filmeService.listarTodos();
    }
    @PostMapping
    public Filme salvar(@RequestBody Filme filme){
        return filmeService.salvar(filme);
    }
}
