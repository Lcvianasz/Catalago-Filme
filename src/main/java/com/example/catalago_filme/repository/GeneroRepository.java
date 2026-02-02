package com.example.catalago_filme.repository;

import com.example.catalago_filme.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
