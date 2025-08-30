package com.softwave.clean_arch_softwave.entities;
import com.softwave.clean_arch_softwave.entities.valueobjects.Cpf;
import com.softwave.clean_arch_softwave.entities.valueobjects.Telefone;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private Integer idade;
    private String email;

    @Embedded
    @AttributeOverride(name = "numero", column = @Column(name = "cpf_numero"))
    private Cpf cpf;

    @Embedded
    @AttributeOverride(name = "numero", column = @Column(name = "telefone_numero"))
    private Telefone telefone;

    private String profissao;
    private Risco risco;
    private double rendaMensal;

    public Cliente() {
    }

    public Cliente(
            String nome,
            Integer idade,
            String email,
            Cpf cpf,
            Telefone telefone,
            String profissao,
            double rendaMensal

    ) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.rendaMensal = rendaMensal;
    }

    public Cliente(
            int id,
            String nome,
            Integer idade,
            String email,
            Cpf cpf,
            Telefone telefone,
            String profissao,
            Risco risco,
            double rendaMensal
    ) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.risco = risco;
        this.rendaMensal = rendaMensal;
    }

    public Cliente(String nome, Integer idade, String email, Cpf cpf, Telefone telefone, String profissao, double rendaMensal, Risco risco) {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
