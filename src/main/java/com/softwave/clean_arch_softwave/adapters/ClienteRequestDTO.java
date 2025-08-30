package com.softwave.clean_arch_softwave.adapters;

import com.softwave.clean_arch_softwave.entities.Cliente;
import com.softwave.clean_arch_softwave.entities.Risco;
import com.softwave.clean_arch_softwave.entities.valueobjects.Cpf;
import com.softwave.clean_arch_softwave.entities.valueobjects.Telefone;
import jakarta.validation.constraints.*;

public class ClienteRequestDTO {

    @NotBlank
    private String nome;

    @NotNull
    private Integer idade;

    @NotBlank
    @Email
    private String email;
    private String cpf;
    private String telefone;
    private String profissao;


    @Positive
    private double rendaMensal;

    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(
            String nome,
            Integer idade,
            String email,
            String cpf,
            String telefone,
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

    public static Cliente toEntity(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente(
                dto.getNome(),
                dto.getIdade(),
                dto.getEmail(),
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
                cliente.getEmail(),
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

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getProfissao() { return profissao; }
    public void setProfissao(String profissao) { this.profissao = profissao; }

    public double getRendaMensal() { return rendaMensal; }
    public void setRendaMensal(double rendaMensal) { this.rendaMensal = rendaMensal; }
}
