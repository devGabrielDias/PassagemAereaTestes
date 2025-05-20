package com.senai.controller;

import com.senai.model.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaReservas {
    private List<Passageiro> passageiros;
    private List<Aviao> avioes;
    private List<Voo> voos;
    private List<Reserva> reservas;
    private int proximoIdPassageiro;
    private int proximoIdAviao;
    private int proximoIdVoo;
    private int proximoIdReserva;

    public SistemaReservas() {
        this.passageiros = new ArrayList<>();
        this.avioes = new ArrayList<>();
        this.voos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.proximoIdPassageiro = 1;
        this.proximoIdAviao = 1;
        this.proximoIdVoo = 1;
        this.proximoIdReserva = 1;
    }

    public Passageiro cadastrarPassageiro(String nome, String cpf, String email) {
        Passageiro passageiro = new Passageiro(proximoIdPassageiro++, nome, cpf, email);
        passageiros.add(passageiro);
        return passageiro;
    }

    public Aviao cadastrarAviao(String modelo, int capacidade, String fabricante) {
        Aviao aviao = new Aviao(proximoIdAviao++, modelo, capacidade, fabricante);
        avioes.add(aviao);
        return aviao;
    }

    public Voo cadastrarVoo(String origem, String destino, LocalDateTime dataHora, Aviao aviao) {
        Voo voo = new Voo(proximoIdVoo++, origem, destino, dataHora, aviao);
        voos.add(voo);
        return voo;
    }

    public Reserva criarReserva(Passageiro passageiro, Voo voo) {
        Reserva reserva = new Reserva(proximoIdReserva++, passageiro, voo);
        reservas.add(reserva);
        return reserva;
    }

    public List<Passageiro> listarPassageiros() {
        return new ArrayList<>(passageiros);
    }

    public List<Aviao> listarAvioes() {
        return new ArrayList<>(avioes);
    }

    public List<Voo> listarVoos() {
        return new ArrayList<>(voos);
    }

    public List<Reserva> listarReservas() {
        return new ArrayList<>(reservas);
    }

    public Passageiro buscarPassageiroPorId(int id) {
        return passageiros.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Aviao buscarAviaoPorId(int id) {
        return avioes.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Voo buscarVooPorId(int id) {
        return voos.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Reserva> buscarReservasPorPassageiro(Passageiro passageiro) {
        return reservas.stream()
                .filter(r -> r.getPassageiro().equals(passageiro))
                .toList();
    }

    public List<Reserva> buscarReservasPorVoo(Voo voo) {
        return reservas.stream()
                .filter(r -> r.getVoo().equals(voo))
                .toList();
    }
} 