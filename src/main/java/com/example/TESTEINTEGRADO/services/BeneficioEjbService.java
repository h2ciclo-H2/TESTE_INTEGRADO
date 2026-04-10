package com.example.TESTEINTEGRADO.services;

import com.example.TESTEINTEGRADO.entity.Beneficio;
import com.example.TESTEINTEGRADO.repository.BeneficioRepoitory;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Stateless
@Service
public class BeneficioEjbService {

    @Autowired
    private BeneficioRepoitory repository;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void transfer(Long fromId, Long toId, BigDecimal amount) {
        Beneficio from = em.find(Beneficio.class, fromId);
        Beneficio to   = em.find(Beneficio.class, toId);

        // BUG: sem validações, sem locking, pode gerar saldo negativo e lost update
        from.setValor(from.getValor().subtract(amount));
        to.setValor(to.getValor().add(amount));

        em.merge(from);
        em.merge(to);
    }
   
    //Localiza beneficio por ID
    public Beneficio buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Benefício não encontrado"));
    }

    //Cria um novo beneficio
    @Transactional
    public void salvar(Beneficio beneficio) {
        beneficio.setId(null); 
        beneficio.setVersion(null);
        em.persist(beneficio);
    }

    @Transactional
    public Beneficio salvarteste(Beneficio beneficio) {
        beneficio.setId(null); 
        beneficio.setVersion(null);
        em.persist(beneficio);
        return beneficio;
    }

    //Atualiza um beneficio existente
    @Transactional
    public void atualizar(Beneficio beneficio) {
        em.merge(beneficio);
    }

    // Exclui um beneficio por 
    @Transactional
    public void excluir(Long id) {
        Beneficio p = em.find(Beneficio.class, id);
        em.remove(p);
    }

    //Lista todos os beneficios
    public List<Beneficio> listarTodosBeneficios() {        
        return repository.findAll(); 
    }
}