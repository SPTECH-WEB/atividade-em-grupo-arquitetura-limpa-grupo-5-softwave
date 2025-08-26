[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/agYdFiud)
# 📊 API de Avaliação de Risco de Crédito

Este projeto é uma prova de conceito para uma API REST que permite o cadastro de clientes e a avaliação automática de risco de crédito, baseada em critérios simples como renda e idade.

A solução foi pensada para ser **modular, extensível e preparada para integração futura** com serviços externos como bureaus de crédito ou sistemas CRM.

---

## 🧠 Contexto

Uma fintech está desenvolvendo um sistema para facilitar a **análise de crédito de novos clientes**. O objetivo desta API é permitir:

- Cadastro de clientes com dados pessoais e financeiros
- Aplicação de uma regra automática de avaliação de risco
- Retorno da classificação com sugestão de estratégia de contato
- Persistência dos dados em memória (com abstração para trocar por banco real ou microserviço externo futuramente)

---

## 🚀 Funcionalidades

- `POST /clientes`  
  Cadastra um cliente e aplica automaticamente a classificação de risco

- `GET /clientes/{id}`  
  Retorna os dados do cliente e sua classificação de risco

---

## 🧾 Modelo de Dados

### Cliente
| Campo         | Tipo      | Validação                            |
|---------------|-----------|--------------------------------------|
| `id`          | UUID/int  | Gerado automaticamente               |
| `nome`        | string    | Obrigatório                          |
| `email`       | string    | Deve conter `@`                      |
| `telefone`    | string    | Deve conter ao menos 10 dígitos      |
| `cpf`         | string    | Formato: `XXX.XXX.XXX-XX`            |
| `rendaMensal` | float     | Obrigatório                          |
| `idade`       | int       | Obrigatório                          |
| `profissao`   | string    | Opcional                             |

---

## 📊 Regras de Classificação de Risco

| Risco   | Critérios                                 | Prioridade | Estratégia de Contato                          |
|---------|--------------------------------------------|------------|------------------------------------------------|
| Baixo   | Renda > 6000 **e** idade > 30              | 3          | Contato automático por e-mail                  |
| Médio   | Renda entre 3000 e 6000 **ou** idade ≤ 30  | 2          | Análise manual em até 48h                      |
| Alto    | Renda < 3000                               | 1          | Contato telefônico em até 24h + análise crítica|

---

## 🏗 Estrutura Recomendada

     +---------------------------+
     |       Controllers        |  --> Camada de Entrada (HTTP)
     +---------------------------+
                 ↓
     +---------------------------+
     |       Use Cases          |  --> Lógica de Negócio
     +---------------------------+
                 ↓
     +---------------------------+
     |       Entities           |  --> Entidades do Domínio
     +---------------------------+
                 ↑
     +---------------------------+
     |     Interfaces/Ports     |  --> Interfaces de Entrada/Saída
     +---------------------------+
                 ↓
     +---------------------------+
     |     Adapters (Infra)     |  --> Implementações: DB, APIs etc.
     +---------------------------+
