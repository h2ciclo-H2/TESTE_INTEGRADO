package com.example.TESTEINTEGRADO.controller;

import org.springframework.web.bind.annotation.*;

import com.example.TESTEINTEGRADO.entity.Beneficio;
import com.example.TESTEINTEGRADO.services.BeneficioEjbService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ejb.EJB;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/api/beneficios")
@Tag(name = "Benefícios", description = "API para gerenciamento de benefícios do sistema")
public class BeneficioController {
    
    @EJB
    private BeneficioEjbService beneficioEjbService = new BeneficioEjbService();
    
    @Operation(summary = "Listar todos os benefícios", description = "Retorna uma lista paginada de todos os benefícios")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @GetMapping
    public List<Beneficio> listarTodosBeneficios() {
    return beneficioEjbService.listarTodosBeneficios();
    }

    @PostMapping("/{idOrigem}/transferir/{idDestino}/{valor}")
    @Operation(summary = "Tranfere o valor de um benefício existente para outro", description = "Transfere o valor de um benefício existente para outro benefício com base no ID fornecido")
    public void transferirBenefico(@PathVariable Long idOrigem,@PathVariable Long idDestino, @PathVariable BigDecimal valor) { 
        
        System.out.println(idOrigem);
        System.out.println(idDestino);
        System.out.println(valor);
        beneficioEjbService.transfer(idOrigem, idDestino, valor); 
    }

    @Operation(summary = "Cria um novo benefício no sistema", description = "Cria um novo benefício com os dados fornecidos")
    @PostMapping
    public void salvarBenefico(@RequestBody Beneficio beneficio) { 
        beneficioEjbService.salvar(beneficio); 
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um benefício existente", description = "Atualiza os dados de um benefício existente com base no ID fornecido")
    public void atualizarBenefico(@PathVariable Long id, @RequestBody Beneficio beneficio) { 
        beneficio.setId(id);
        beneficioEjbService.atualizar(beneficio); 
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um benefício", description = "Exclui um benefício existente com base no ID fornecido")
    public void excluirBenefico(@PathVariable Long id) { 
        beneficioEjbService.excluir(id); 
    }
}