package com.example.catalago_filme.controller;

import com.example.catalago_filme.model.Genero;
import com.example.catalago_filme.service.GeneroService;
import com.example.catalago_filme.repository.GeneroRepository;
import org.springframework.web.bind.annotation.*;
import lombok.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
@RequiredArgsConstructor
public class GeneroController {

    private final GeneroService generoService;

    @GetMapping
    public List<Genero> listar(){
        return generoService.listarTodos();
    }

    @PostMapping
    public Genero salvar(@RequestBody Genero genero){
        return generoService.salvar(genero);
    }
}
