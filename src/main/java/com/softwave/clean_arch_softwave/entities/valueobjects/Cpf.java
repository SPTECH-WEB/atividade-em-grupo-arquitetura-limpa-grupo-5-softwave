package com.softwave.clean_arch_softwave.entities.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public final class Cpf
{

    private final String numero;

    protected Cpf() {
        this.numero = null;
    }

    public Cpf(String numero)
    {
        Objects.requireNonNull(numero, "CPF não pode ser nulo");
        String digitos = numero.replaceAll("\\D", "");
        if (!isValid(digitos))
        {
            throw new IllegalArgumentException("CPF inválido: " + numero);
        }
        this.numero = digitos;
    }




    public String getNumero() {
        return numero;
    }

    public String format()
    {
        return String.format("%s.%s.%s-%s",
                numero.substring(0, 3),
                numero.substring(3, 6),
                numero.substring(6, 9),
                numero.substring(9));
    }

    private boolean isValid(String cpf)
    {
        if (cpf == null || cpf.length() != 11) return false;
        if (cpf.matches("(\\d)\\1{10}")) return false;

        try
        {
            int soma = 0;
            for (int i = 0; i < 9; i++)
                soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);

            int resto = soma % 11;
            int dig1 = (resto < 2) ? 0 : 11 - resto;
            if (dig1 != Character.getNumericValue(cpf.charAt(9))) return false;

            soma = 0;
            for (int i = 0; i < 10; i++)
                soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);

            resto = soma % 11;
            int dig2 = (resto < 2) ? 0 : 11 - resto;
            return dig2 == Character.getNumericValue(cpf.charAt(10));
        } catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Cpf)) return false;
        Cpf cpf = (Cpf) o;
        return numero.equals(cpf.numero);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(numero);
    }

    @Override
    public String toString()
    {
        return format();
    }
}