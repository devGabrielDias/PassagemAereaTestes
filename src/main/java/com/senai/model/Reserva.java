package com.senai.model;

import java.time.LocalDateTime;

public class Reserva {
    private int id;
    private Passageiro passageiro;
    private Voo voo;
    private LocalDateTime dataReserva;

    public Reserva(int id, Passageiro passageiro, Voo voo) {
        if (passageiro == null) {
            throw new IllegalArgumentException("A reserva deve estar vinculada a um passageiro");
        }
        if (voo == null) {
            throw new IllegalArgumentException("A reserva deve estar vinculada a um voo");
        }
        if (!voo.temVagasDisponiveis()) {
            throw new IllegalStateException("Não há vagas disponíveis para este voo");
        }

        this.id = id;
        this.passageiro = passageiro;
        this.voo = voo;
        this.dataReserva = LocalDateTime.now();

        voo.adicionarReserva(this);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        if (passageiro == null) {
            throw new IllegalArgumentException("A reserva deve estar vinculada a um passageiro");
        }
        this.passageiro = passageiro;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        if (voo == null) {
            throw new IllegalArgumentException("A reserva deve estar vinculada a um voo");
        }
        if (!voo.temVagasDisponiveis()) {
            throw new IllegalStateException("Não há vagas disponíveis para este voo");
        }
        this.voo.removerReserva(this);
        this.voo = voo;
        voo.adicionarReserva(this);
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", passageiro=" + passageiro +
                ", voo=" + voo +
                ", dataReserva=" + dataReserva +
                '}';
    }
} 