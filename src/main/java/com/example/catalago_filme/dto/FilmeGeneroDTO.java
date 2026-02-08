package com.example.catalago_filme.dto;

import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmeGeneroDTO {

    private Set<Long> generosIds;
}
