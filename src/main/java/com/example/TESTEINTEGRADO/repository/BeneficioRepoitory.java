package com.example.TESTEINTEGRADO.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TESTEINTEGRADO.entity.Beneficio;

public interface BeneficioRepoitory extends JpaRepository<Beneficio, Long> {

    // Retorna uma lista de benefícios ativos
    ArrayList<Beneficio> findByAtivoTrue();

}
