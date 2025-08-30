package com.softwave.clean_arch_softwave.entities;

public enum Risco {
    BAIXO(3, "Contato automático por e-mail"),
    MEDIO(2, "Análise manual em até 48h"),
    ALTO(1, "Contato telefônico em até 24h + análise crítica");

    private final int prioridade;
    private final String estrategiaContato;

    Risco(int prioridade, String estrategiaContato) {
        this.prioridade = prioridade;
        this.estrategiaContato = estrategiaContato;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getEstrategiaContato() {
        return estrategiaContato;
    }

    public static Risco avaliarRisco(double renda, int idade) {
        if (renda > 6000 && idade > 30) {
            return BAIXO;
        } else if (renda < 3000) {
            return ALTO;
        } else if ((renda >= 3000 && renda <= 6000) || idade <= 30) {
            return MEDIO;
        } else {
            return ALTO;
        }
    }
}
