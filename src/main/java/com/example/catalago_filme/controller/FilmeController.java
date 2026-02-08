package com.example.catalago_filme.controller;

import com.example.catalago_filme.dto.FilmeGeneroDTO;
import com.example.catalago_filme.dto.FilmeRequestDTO;
import com.example.catalago_filme.dto.FilmeResponseDTO;
import com.example.catalago_filme.service.FilmeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.*;

import java.util.List;


@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;

    @PostMapping
    public ResponseEntity<FilmeResponseDTO> criar(
            @RequestBody FilmeRequestDTO dto
    ) {
        return ResponseEntity.ok(filmeService.criar(dto));
    }


    @PostMapping("/{filmeId}/generos")
    public ResponseEntity<FilmeResponseDTO> adicionarGeneros(
            @PathVariable Long filmeId,
            @RequestBody FilmeGeneroDTO dto
    ) {
        return ResponseEntity.ok(
                filmeService.adicionarGeneros(filmeId, dto)
        );
    }

    @GetMapping
    public ResponseEntity<List<FilmeResponseDTO>> listar() {
        return ResponseEntity.ok(filmeService.listar());
    }

}
