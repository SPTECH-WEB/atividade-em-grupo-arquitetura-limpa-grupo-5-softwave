package com.softwave.clean_arch_softwave.adapters;

import com.softwave.clean_arch_softwave.entities.Cliente;
import com.softwave.clean_arch_softwave.entities.Risco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
public class ClienteResponseDTO {

    private int id;

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

    private Risco risco;
    private String estrategiaContato;
    private int prioridade;

    public ClienteResponseDTO() {}

    public static ClienteResponseDTO toResponseDto(Cliente cliente) {
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setIdade(cliente.getIdade());
        dto.setEmail(cliente.getEmail());
        dto.setCpf(cliente.getCpf().getNumero());
        dto.setTelefone(cliente.getTelefone().getNumero());
        dto.setProfissao(cliente.getProfissao());
        dto.setRendaMensal(cliente.getRendaMensal());

        if (cliente.getRisco() != null) {
            dto.setRisco(cliente.getRisco());
            dto.setEstrategiaContato(cliente.getRisco().getEstrategiaContato());
            dto.setPrioridade(cliente.getRisco().getPrioridade());
        }

        return dto;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

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

    public Risco getRisco() { return risco; }
    public void setRisco(Risco risco) { this.risco = risco; }

    public String getEstrategiaContato() { return estrategiaContato; }
    public void setEstrategiaContato(String estrategiaContato) { this.estrategiaContato = estrategiaContato; }

    public int getPrioridade() { return prioridade; }
    public void setPrioridade(int prioridade) { this.prioridade = prioridade; }
}
