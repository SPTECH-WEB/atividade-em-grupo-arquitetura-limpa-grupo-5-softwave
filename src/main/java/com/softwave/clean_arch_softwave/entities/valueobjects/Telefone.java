package com.softwave.clean_arch_softwave.entities.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public final class Telefone {

    private final String numero;

    protected Telefone() {
        this.numero = null;
    }

    public Telefone(String numero) {
        Objects.requireNonNull(numero, "Telefone não pode ser nulo");
        String digitos = numero.replaceAll("\\D", "");
        if (!isValid(digitos)) {
            throw new IllegalArgumentException("Telefone inválido: " + numero);
        }
        this.numero = digitos;
    }



    public String getNumero() {
        return numero;
    }


    public String format() {
        if (numero.length() == 10) {
            // Telefone fixo: (XX) XXXX-XXXX
            return String.format("(%s) %s-%s",
                    numero.substring(0, 2),
                    numero.substring(2, 6),
                    numero.substring(6));
        } else if (numero.length() == 11) {
            // Celular: (XX) XXXXX-XXXX
            return String.format("(%s) %s-%s",
                    numero.substring(0, 2),
                    numero.substring(2, 7),
                    numero.substring(7));
        } else {
            // Formato genérico para outros casos
            return numero;
        }
    }

    private boolean isValid(String telefone) {
        if (telefone == null || telefone.length() < 10 || telefone.length() > 11) {
            return false;
        }
        
        // Verifica se todos os caracteres são dígitos
        if (!telefone.matches("\\d+")) {
            return false;
        }
        
        // Validações específicas para telefones brasileiros
        if (telefone.length() == 10) {
            // Telefone fixo: deve começar com dígito diferente de 0
            return telefone.charAt(0) != '0';
        } else if (telefone.length() == 11) {
            // Celular: deve começar com 9 (para números móveis) ou dígito diferente de 0 (para fixos)
            return telefone.charAt(2) == '9' || telefone.charAt(0) != '0';
        }
        
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefone)) return false;
        Telefone telefone = (Telefone) o;
        return numero.equals(telefone.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return format();
    }
} 