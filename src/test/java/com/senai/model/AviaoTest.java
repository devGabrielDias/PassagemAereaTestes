package com.senai.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AviaoTest {

    // Cadastrar avião com modelo e capacidade válidos → Deve ser salvo corretamente
    @Test
    void testCriarAviaoComDadosValidos() {
        Aviao aviao = new Aviao(1, "Boeing 737", 150, "Boeing");
        assertEquals(1, aviao.getId());
        assertEquals("Boeing 737", aviao.getModelo());
        assertEquals(150, aviao.getCapacidade());
        assertEquals("Boeing", aviao.getFabricante());
    }

    // Tentar cadastrar avião com capacidade zero → Deve lançar exceção ou falhar
    @Test
    void testCriarAviaoComCapacidadeZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Aviao(1, "Boeing 737", 0, "Boeing");
        });
    }

    // Tentar cadastrar avião com capacidade negativa → Deve lançar exceção ou falhar
    @Test
    void testCriarAviaoComCapacidadeNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Aviao(1, "Boeing 737", -150, "Boeing");
        });
    }

    // Alterar capacidade do avião para um valor válido → Deve atualizar corretamente
    @Test
    void testSetCapacidadeValida() {
        Aviao aviao = new Aviao(1, "Boeing 737", 150, "Boeing");
        aviao.setCapacidade(200);
        assertEquals(200, aviao.getCapacidade());
    }

    // Alterar capacidade do avião para um valor inválido (zero) → Deve lançar exceção
    @Test
    void testSetCapacidadeInvalida() {
        Aviao aviao = new Aviao(1, "Boeing 737", 150, "Boeing");
        assertThrows(IllegalArgumentException.class, () -> {
            aviao.setCapacidade(0);
        });
    }

    // Adicionar e remover voo do avião → Deve atualizar a lista de voos corretamente
    @Test
    void testAdicionarERemoverVoo() {
        Aviao aviao = new Aviao(1, "Boeing 737", 150, "Boeing");
        Voo voo = new Voo(1, "São Paulo", "Rio de Janeiro", null, aviao);

        assertEquals(1, aviao.getVoos().size());
        assertTrue(aviao.getVoos().contains(voo));

        aviao.removerVoo(voo);
        assertEquals(0, aviao.getVoos().size());
        assertFalse(aviao.getVoos().contains(voo));
    }
} 