package com.senai.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PassageiroTest {

    // Cadastrar passageiro com dados válidos → Deve adicionar à lista
    @Test
    void testCriarPassageiroComDadosValidos() {
        Passageiro passageiro = new Passageiro(1, "João Silva", "52998224725", "joao.silva@email.com");
        assertEquals(1, passageiro.getId());
        assertEquals("João Silva", passageiro.getNome());
        assertEquals("52998224725", passageiro.getCpf());
        assertEquals("joao.silva@email.com", passageiro.getEmail());
    }

    // Tentar cadastrar passageiro com CPF inválido → Deve falhar ou lançar exceção
    @Test
    void testCriarPassageiroComCPFInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Passageiro(1, "João Silva", "12345678900", "joao.silva@email.com");
        });
    }

    // Tentar cadastrar passageiro com e-mail inválido → Deve falhar ou lançar exceção
    @Test
    void testCriarPassageiroComEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Passageiro(1, "João Silva", "52998224725", "joao.silva");
        });
    }

    // Testar CPF válido (exemplo: "52998224725") → Deve retornar true
    @Test
    void testSetCPFValido() {
        Passageiro passageiro = new Passageiro(1, "João Silva", "52998224725", "joao.silva@email.com");
        passageiro.setCpf("52998224725");
        assertEquals("52998224725", passageiro.getCpf());
    }

    // Testar CPF inválido (exemplo: "12345678900") → Deve retornar false
    @Test
    void testSetCPFInvalido() {
        Passageiro passageiro = new Passageiro(1, "João Silva", "52998224725", "joao.silva@email.com");
        assertThrows(IllegalArgumentException.class, () -> {
            passageiro.setCpf("12345678900");
        });
    }

    // Testar e-mail válido (exemplo: "ana.souza@email.com") → Deve retornar true
    @Test
    void testSetEmailValido() {
        Passageiro passageiro = new Passageiro(1, "João Silva", "52998224725", "joao.silva@email.com");
        passageiro.setEmail("novo.email@dominio.com");
        assertEquals("novo.email@dominio.com", passageiro.getEmail());
    }

    // Testar e-mail inválido (exemplo: "ana.souza@com") → Deve retornar false
    @Test
    void testSetEmailInvalido() {
        Passageiro passageiro = new Passageiro(1, "João Silva", "52998224725", "joao.silva@email.com");
        assertThrows(IllegalArgumentException.class, () -> {
            passageiro.setEmail("email.invalido");
        });
    }
} 