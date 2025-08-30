package com.softwave.clean_arch_softwave.entities.valueobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TelefoneTest {

    @Test
    public void testTelefoneValidoFixo() {
        Telefone telefone = new Telefone("1133334444");
        assertEquals("1133334444", telefone.getNumero());
        assertEquals("(11) 3333-4444", telefone.format());
    }

    @Test
    public void testTelefoneValidoCelular() {
        Telefone telefone = new Telefone("11999998888");
        assertEquals("11999998888", telefone.getNumero());
        assertEquals("(11) 99999-8888", telefone.format());
    }

    @Test
    public void testTelefoneComFormatacao() {
        Telefone telefone = new Telefone("(11) 3333-4444");
        assertEquals("1133334444", telefone.getNumero());
        assertEquals("(11) 3333-4444", telefone.format());
    }

    @Test
    public void testTelefoneComEspacos() {
        Telefone telefone = new Telefone("11 3333 4444");
        assertEquals("1133334444", telefone.getNumero());
        assertEquals("(11) 3333-4444", telefone.format());
    }

    @Test
    public void testTelefoneInvalidoMenosDigitos() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Telefone("113333444");
        });
    }

    @Test
    public void testTelefoneInvalidoMaisDigitos() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Telefone("11333344444");
        });
    }

    @Test
    public void testTelefoneNulo() {
        assertThrows(NullPointerException.class, () -> {
            new Telefone(null);
        });
    }

    @Test
    public void testTelefoneComLetras() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Telefone("11ABC3333");
        });
    }

    @Test
    public void testEquals() {
        Telefone telefone1 = new Telefone("1133334444");
        Telefone telefone2 = new Telefone("1133334444");
        Telefone telefone3 = new Telefone("11999998888");
        
        assertEquals(telefone1, telefone2);
        assertNotEquals(telefone1, telefone3);
    }

    @Test
    public void testHashCode() {
        Telefone telefone1 = new Telefone("1133334444");
        Telefone telefone2 = new Telefone("1133334444");
        
        assertEquals(telefone1.hashCode(), telefone2.hashCode());
    }
} 