package com.senai.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class ReservaTest {

    // Criar reserva com vagas disponíveis → Deve ser realizada com sucesso
    @Test
    void testCriarReservaComDadosValidos() {
        Aviao aviao = new Aviao(1, "Boeing 737", 150, "Boeing");
        Voo voo = new Voo(1, "São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao);
        Passageiro passageiro = new Passageiro(1, "João Silva", "52998224725", "joao.silva@email.com");

        Reserva reserva = new Reserva(1, passageiro, voo);

        assertEquals(1, reserva.getId());
        assertEquals(passageiro, reserva.getPassageiro());
        assertEquals(voo, reserva.getVoo());
        assertNotNull(reserva.getDataReserva());
    }

    // Criar reserva sem passageiro → Deve lançar exceção ou falhar
    @Test
    void testCriarReservaSemPassageiro() {
        Aviao aviao = new Aviao(1, "Boeing 737", 150, "Boeing");
        Voo voo = new Voo(1, "São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao);

        assertThrows(IllegalArgumentException.class, () -> {
            new Reserva(1, null, voo);
        });
    }

    // Criar reserva sem voo associado → Deve lançar exceção ou falhar
    @Test
    void testCriarReservaSemVoo() {
        Passageiro passageiro = new Passageiro(1, "João Silva", "52998224725", "joao.silva@email.com");

        assertThrows(IllegalArgumentException.class, () -> {
            new Reserva(1, passageiro, null);
        });
    }

    // Criar reserva quando todas as vagas estiverem ocupadas → Deve falhar ou lançar exceção
    @Test
    void testCriarReservaSemVagasDisponiveis() {
        Aviao aviao = new Aviao(1, "Boeing 737", 1, "Boeing");
        Voo voo = new Voo(1, "São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao);
        Passageiro passageiro1 = new Passageiro(1, "João Silva", "04418392904", "joao.silva@email.com");
        Passageiro passageiro2 = new Passageiro(2, "Maria Santos", "66582263188", "maria.santos@email.com");

        new Reserva(1, passageiro1, voo);

        assertThrows(IllegalStateException.class, () -> {
            new Reserva(2, passageiro2, voo);
        });
    }

    // Alterar passageiro de uma reserva → Deve atualizar corretamente
    @Test
    void testSetPassageiro() {
        Aviao aviao = new Aviao(1, "Boeing 737", 150, "Boeing");
        Voo voo = new Voo(1, "São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao);
        Passageiro passageiro1 = new Passageiro(1, "João Silva", "04418392904", "joao.silva@email.com");
        Passageiro passageiro2 = new Passageiro(2, "Maria Santos", "66582263188", "maria.santos@email.com");

        Reserva reserva = new Reserva(1, passageiro1, voo);
        reserva.setPassageiro(passageiro2);

        assertEquals(passageiro2, reserva.getPassageiro());
    }

    // Alterar passageiro para nulo em uma reserva → Deve lançar exceção
    @Test
    void testSetPassageiroNulo() {
        Aviao aviao = new Aviao(1, "Boeing 737", 150, "Boeing");
        Voo voo = new Voo(1, "São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao);
        Passageiro passageiro = new Passageiro(1, "João Silva", "52998224725", "joao.silva@email.com");

        Reserva reserva = new Reserva(1, passageiro, voo);

        assertThrows(IllegalArgumentException.class, () -> {
            reserva.setPassageiro(null);
        });
    }

    // Alterar voo de uma reserva → Deve atualizar corretamente
    @Test
    void testSetVoo() {
        Aviao aviao1 = new Aviao(1, "Boeing 737", 150, "Boeing");
        Aviao aviao2 = new Aviao(2, "Airbus A320", 180, "Airbus");
        Voo voo1 = new Voo(1, "São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao1);
        Voo voo2 = new Voo(2, "Rio de Janeiro", "Belo Horizonte", LocalDateTime.now(), aviao2);
        Passageiro passageiro = new Passageiro(1, "João Silva", "52998224725", "joao.silva@email.com");

        Reserva reserva = new Reserva(1, passageiro, voo1);
        reserva.setVoo(voo2);

        assertEquals(voo2, reserva.getVoo());
    }

    // Alterar voo para nulo em uma reserva → Deve lançar exceção
    @Test
    void testSetVooNulo() {
        Aviao aviao = new Aviao(1, "Boeing 737", 150, "Boeing");
        Voo voo = new Voo(1, "São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao);
        Passageiro passageiro = new Passageiro(1, "João Silva", "52998224725", "joao.silva@email.com");

        Reserva reserva = new Reserva(1, passageiro, voo);

        assertThrows(IllegalArgumentException.class, () -> {
            reserva.setVoo(null);
        });
    }
} 