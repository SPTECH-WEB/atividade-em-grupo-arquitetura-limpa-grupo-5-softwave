package com.softwave.clean_arch_softwave.entities;

import jdk.jfr.Name;

import java.util.UUID;

public class Cliente {

    @Id
    private UUID id;

    @Name("nome_completo")
    private String nome;

    @NotBlank
    private Integer idade;

    private String profissao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}
