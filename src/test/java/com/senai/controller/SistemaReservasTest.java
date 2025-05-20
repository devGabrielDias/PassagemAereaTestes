package com.senai.controller;

import com.senai.model.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SistemaReservasTest {

    @Test
    void testCadastrarPassageiro() {
        SistemaReservas sistema = new SistemaReservas();
        Passageiro passageiro = sistema.cadastrarPassageiro("João Silva", "52998224725", "joao.silva@email.com");

        assertNotNull(passageiro);
        assertEquals(1, passageiro.getId());
        assertEquals("João Silva", passageiro.getNome());
        assertEquals("52998224725", passageiro.getCpf());
        assertEquals("joao.silva@email.com", passageiro.getEmail());

        List<Passageiro> passageiros = sistema.listarPassageiros();
        assertEquals(1, passageiros.size());
        assertTrue(passageiros.contains(passageiro));
    }

    @Test
    void testCadastrarAviao() {
        SistemaReservas sistema = new SistemaReservas();
        Aviao aviao = sistema.cadastrarAviao("Boeing 737", 150, "Boeing");

        assertNotNull(aviao);
        assertEquals(1, aviao.getId());
        assertEquals("Boeing 737", aviao.getModelo());
        assertEquals(150, aviao.getCapacidade());
        assertEquals("Boeing", aviao.getFabricante());

        List<Aviao> avioes = sistema.listarAvioes();
        assertEquals(1, avioes.size());
        assertTrue(avioes.contains(aviao));
    }

    @Test
    void testCadastrarVoo() {
        SistemaReservas sistema = new SistemaReservas();
        Aviao aviao = sistema.cadastrarAviao("Boeing 737", 150, "Boeing");
        LocalDateTime dataHora = LocalDateTime.now();
        Voo voo = sistema.cadastrarVoo("São Paulo", "Rio de Janeiro", dataHora, aviao);

        assertNotNull(voo);
        assertEquals(1, voo.getId());
        assertEquals("São Paulo", voo.getOrigem());
        assertEquals("Rio de Janeiro", voo.getDestino());
        assertEquals(dataHora, voo.getDataHora());
        assertEquals(aviao, voo.getAviao());

        List<Voo> voos = sistema.listarVoos();
        assertEquals(1, voos.size());
        assertTrue(voos.contains(voo));
    }

    @Test
    void testCriarReserva() {
        SistemaReservas sistema = new SistemaReservas();
        Passageiro passageiro = sistema.cadastrarPassageiro("João Silva", "52998224725", "joao.silva@email.com");
        Aviao aviao = sistema.cadastrarAviao("Boeing 737", 150, "Boeing");
        Voo voo = sistema.cadastrarVoo("São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao);

        Reserva reserva = sistema.criarReserva(passageiro, voo);

        assertNotNull(reserva);
        assertEquals(1, reserva.getId());
        assertEquals(passageiro, reserva.getPassageiro());
        assertEquals(voo, reserva.getVoo());

        List<Reserva> reservas = sistema.listarReservas();
        assertEquals(1, reservas.size());
        assertTrue(reservas.contains(reserva));
    }

    @Test
    void testBuscarPassageiroPorId() {
        SistemaReservas sistema = new SistemaReservas();
        Passageiro passageiro = sistema.cadastrarPassageiro("João Silva", "52998224725", "joao.silva@email.com");

        Passageiro encontrado = sistema.buscarPassageiroPorId(1);
        assertNotNull(encontrado);
        assertEquals(passageiro, encontrado);

        Passageiro naoEncontrado = sistema.buscarPassageiroPorId(999);
        assertNull(naoEncontrado);
    }

    @Test
    void testBuscarAviaoPorId() {
        SistemaReservas sistema = new SistemaReservas();
        Aviao aviao = sistema.cadastrarAviao("Boeing 737", 150, "Boeing");

        Aviao encontrado = sistema.buscarAviaoPorId(1);
        assertNotNull(encontrado);
        assertEquals(aviao, encontrado);

        Aviao naoEncontrado = sistema.buscarAviaoPorId(999);
        assertNull(naoEncontrado);
    }

    @Test
    void testBuscarVooPorId() {
        SistemaReservas sistema = new SistemaReservas();
        Aviao aviao = sistema.cadastrarAviao("Boeing 737", 150, "Boeing");
        Voo voo = sistema.cadastrarVoo("São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao);

        Voo encontrado = sistema.buscarVooPorId(1);
        assertNotNull(encontrado);
        assertEquals(voo, encontrado);

        Voo naoEncontrado = sistema.buscarVooPorId(999);
        assertNull(naoEncontrado);
    }

    @Test
    void testBuscarReservasPorPassageiro() {
        SistemaReservas sistema = new SistemaReservas();
        Passageiro passageiro = sistema.cadastrarPassageiro("João Silva", "52998224725", "joao.silva@email.com");
        Aviao aviao = sistema.cadastrarAviao("Boeing 737", 150, "Boeing");
        Voo voo = sistema.cadastrarVoo("São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao);

        Reserva reserva = sistema.criarReserva(passageiro, voo);

        List<Reserva> reservas = sistema.buscarReservasPorPassageiro(passageiro);
        assertEquals(1, reservas.size());
        assertTrue(reservas.contains(reserva));
    }

    @Test
    void testBuscarReservasPorVoo() {
        SistemaReservas sistema = new SistemaReservas();
        Passageiro passageiro = sistema.cadastrarPassageiro("João Silva", "52998224725", "joao.silva@email.com");
        Aviao aviao = sistema.cadastrarAviao("Boeing 737", 150, "Boeing");
        Voo voo = sistema.cadastrarVoo("São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviao);

        Reserva reserva = sistema.criarReserva(passageiro, voo);

        List<Reserva> reservas = sistema.buscarReservasPorVoo(voo);
        assertEquals(1, reservas.size());
        assertTrue(reservas.contains(reserva));
    }
} 