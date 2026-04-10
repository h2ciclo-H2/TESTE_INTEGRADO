package com.example.TESTEINTEGRADO.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "beneficio")
public class Beneficio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome ;
    
    private String descricao;

    @Column(precision = 10, scale = 2)
    private BigDecimal valor;

    private boolean ativo;

    @Version 
    private Long version;

    public Beneficio() {
    }

    public Beneficio(String nome, BigDecimal valor, boolean ativo) {
        this.nome = nome;
        this.valor = valor;
        this.ativo = ativo;
    }
    
    public Beneficio(String nome, String descricao, BigDecimal valor, boolean ativo, Long version) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.ativo = ativo;
        this.version = version;
    }

    public Beneficio(Long id, String nome, String descricao, BigDecimal valor, boolean ativo, Long version) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.ativo = ativo;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return " Beneficio id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", valor=" + valor + ", ativo="
                + ativo + ", version=" + version ;
    }    
}