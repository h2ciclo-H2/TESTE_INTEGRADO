package com.example;


import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.TESTEINTEGRADO.TesteintegradoApplication;
import com.example.TESTEINTEGRADO.entity.Beneficio;
import com.example.TESTEINTEGRADO.services.BeneficioEjbService;

import jakarta.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = TesteintegradoApplication.class)
@ExtendWith(MockitoExtension.class)
@Transactional
class BeneficioServiceTest {

    @Autowired
    private BeneficioEjbService service;

    @Test
    void deveSalvarNovoBeneficio() {
        Beneficio b = new Beneficio();
        b.setNome("Beneficio A");
        b.setValor(new BigDecimal("500.00"));
        b.setAtivo(true);

        Beneficio salvo = service.salvarteste(b);

        assertNotNull(salvo.getId());
        assertEquals("Beneficio A", salvo.getNome());
    }

    @Test
    void deveListarBeneficios() {
        List<Beneficio> lista = service.listarTodosBeneficios();
        assertNotNull(lista);
    }

    @Test
    void deveExcluirBeneficio() {
        Beneficio b = new Beneficio();
        b.setNome("Beneficio A");
        b.setValor(new BigDecimal("500.00"));
        b.setAtivo(true);

        Beneficio salvo = service.salvarteste(b);
        
        Long id = salvo.getId();
        service.excluir(id);
        assertFalse(service.listarTodosBeneficios().stream().anyMatch(ben -> ben.getId().equals(id)));
    }
}