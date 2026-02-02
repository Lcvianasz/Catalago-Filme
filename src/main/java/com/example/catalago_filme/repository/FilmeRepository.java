package com.example.catalago_filme.repository;

import com.example.catalago_filme.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
