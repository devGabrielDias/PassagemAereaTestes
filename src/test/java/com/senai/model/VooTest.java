package com.senai.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class VooTest {

    // Cadastrar voo com origem, destino, data e avião válido → Deve ser salvo corretamente
    @Test
    void testCriarVooComDadosValidos() {
        Aviao aviao = new Aviao(1, "Boeing 737", 150, "Boeing");
        LocalDateTime dataHora = LocalDateTime.now();
        Voo voo = new Voo(1, "São Paulo", "Rio de Janeiro", dataHora, aviao);

        assertEquals(1, voo.getId());
        assertEquals("São Paulo", voo.getOrigem());
        assertEquals("Rio de Janeiro", voo.getDestino());
        assertEquals(dataHora, voo.getDataHora());
        assertEquals(aviao, voo.getAviao());
        assertEquals(150, voo.getVagasDisponiveis());
    }

    // Tentar cadastrar voo sem avião associado → Deve lançar exceção ou falhar
    @Test
    void testCriarVooSemAviao() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Voo(1, "São Paulo", "Rio de Janeiro", LocalDateTime.now(), null);
        });
    }

    // Verificar vagas disponíveis em voo → Deve retornar corretamente
    @Test
    void testVagasDisponiveis() {
        Aviao aviao = new Aviao(1, "Boeing 737", 150, "Boeing");
        Voo voo = new Voo(1, "São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao);

        assertEquals(150, voo.getVagasDisponiveis());
        assertTrue(voo.temVagasDisponiveis());
    }

    // Adicionar reserva ao voo → Deve atualizar vagas disponíveis e lista de reservas
    @Test
    void testAdicionarReserva() {
        Aviao aviao = new Aviao(1, "Boeing 737", 150, "Boeing");
        Voo voo = new Voo(1, "São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao);
        Passageiro passageiro = new Passageiro(1, "João Silva", "52998224725", "joao.silva@email.com");
        Reserva reserva = new Reserva(1, passageiro, voo);

        assertEquals(149, voo.getVagasDisponiveis());
        assertEquals(1, voo.getReservas().size());
        assertTrue(voo.getReservas().contains(reserva));
    }

    // Remover reserva do voo → Deve atualizar vagas disponíveis e lista de reservas
    @Test
    void testRemoverReserva() {
        Aviao aviao = new Aviao(1, "Boeing 737", 150, "Boeing");
        Voo voo = new Voo(1, "São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao);
        Passageiro passageiro = new Passageiro(1, "João Silva", "52998224725", "joao.silva@email.com");
        Reserva reserva = new Reserva(1, passageiro, voo);

        voo.removerReserva(reserva);
        assertEquals(150, voo.getVagasDisponiveis());
        assertEquals(0, voo.getReservas().size());
        assertFalse(voo.getReservas().contains(reserva));
    }

    // Alterar avião de um voo → Deve atualizar corretamente
    @Test
    void testSetAviao() {
        Aviao aviao1 = new Aviao(1, "Boeing 737", 150, "Boeing");
        Aviao aviao2 = new Aviao(2, "Airbus A320", 180, "Airbus");
        Voo voo = new Voo(1, "São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao1);

        voo.setAviao(aviao2);
        assertEquals(aviao2, voo.getAviao());
        assertEquals(180, voo.getVagasDisponiveis());
    }

    // Alterar avião para nulo em um voo → Deve lançar exceção
    @Test
    void testSetAviaoNulo() {
        Aviao aviao = new Aviao(1, "Boeing 737", 150, "Boeing");
        Voo voo = new Voo(1, "São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao);

        assertThrows(IllegalArgumentException.class, () -> {
            voo.setAviao(null);
        });
    }
} 