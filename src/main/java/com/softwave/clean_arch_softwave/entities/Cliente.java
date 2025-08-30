package com.softwave.clean_arch_softwave.entities;
import com.softwave.clean_arch_softwave.entities.valueobjects.Cpf;
import com.softwave.clean_arch_softwave.entities.valueobjects.Telefone;

import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Name;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Cliente {

    @Id
    private UUID id;

    @Name("nome_completo")
    private String nome;

    @NotBlank
    private Integer idade;

    private Cpf cpf;

    private Telefone telefone;

    private String profissao;

    private Risco risco;

    private double rendaMensal;

    public Cliente() {
    }

    public Cliente(
            String nome,
            Integer idade,
            Cpf cpf,
            Telefone telefone,
            String profissao,
            double rendaMensal

    ) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.rendaMensal = rendaMensal;
    }

    public Cliente(
            UUID id,
            String nome,
            Integer idade,
            Cpf cpf,
            Telefone telefone,
            String profissao,
            Risco risco,
            double rendaMensal
    ) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.risco = risco;
        this.rendaMensal = rendaMensal;
    }

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
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

    public Cpf getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = new Cpf(cpf);
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = new Telefone(telefone);
    }

    public Risco getRisco() {
        return risco;
    }

    public void setRisco(int idade, double renda) {
        this.risco = Risco.avaliarRisco(renda, idade);
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }
}
