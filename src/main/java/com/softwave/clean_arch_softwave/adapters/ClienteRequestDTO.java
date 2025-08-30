package com.softwave.clean_arch_softwave.adapters;

import com.softwave.clean_arch_softwave.entities.Cliente;
import com.softwave.clean_arch_softwave.entities.Risco;
import com.softwave.clean_arch_softwave.entities.valueobjects.Cpf;
import com.softwave.clean_arch_softwave.entities.valueobjects.Telefone;

import java.util.UUID;

public class ClienteRequestDTO {

    private String nome;
    private Integer idade;
    private String cpf;
    private String telefone;
    private String profissao;
    private double rendaMensal;

    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(
            String nome,
            Integer idade,
            String cpf,
            String telefone,
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

    public static Cliente toEntity(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente(
                dto.getNome(),
                dto.getIdade(),
                new Cpf(dto.getCpf()),
                new Telefone(dto.getTelefone()),
                dto.getProfissao(),
                dto.getRendaMensal()
        );

        return cliente;
    }

    public static ClienteRequestDTO toDTO(Cliente cliente) {
        return new ClienteRequestDTO(
                cliente.getNome(),
                cliente.getIdade(),
                cliente.getCpf() != null ? cliente.getCpf().getNumero() : null,
                cliente.getTelefone() != null ? cliente.getTelefone().getNumero() : null,
                cliente.getProfissao(),
                cliente.getRendaMensal()
        );
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getProfissao() { return profissao; }
    public void setProfissao(String profissao) { this.profissao = profissao; }

    public double getRendaMensal() { return rendaMensal; }
    public void setRendaMensal(double rendaMensal) { this.rendaMensal = rendaMensal; }
}
