package com.senai.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Voo {
    private int id;
    private String origem;
    private String destino;
    private LocalDateTime dataHora;
    private Aviao aviao;
    private List<Reserva> reservas;

    public Voo(int id, String origem, String destino, LocalDateTime dataHora, Aviao aviao) {
        if (aviao == null) {
            throw new IllegalArgumentException("O voo deve estar vinculado a um avião");
        }
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.dataHora = dataHora;
        this.aviao = aviao;
        this.reservas = new ArrayList<>();
        aviao.adicionarVoo(this);
    }

    public int getVagasDisponiveis() {
        return aviao.getCapacidade() - reservas.size();
    }

    public boolean temVagasDisponiveis() {
        return getVagasDisponiveis() > 0;
    }

    public void adicionarReserva(Reserva reserva) {
        if (!temVagasDisponiveis()) {
            throw new IllegalStateException("Não há vagas disponíveis para este voo");
        }
        this.reservas.add(reserva);
    }

    public void removerReserva(Reserva reserva) {
        this.reservas.remove(reserva);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        if (aviao == null) {
            throw new IllegalArgumentException("O voo deve estar vinculado a um avião");
        }
        this.aviao.removerVoo(this);
        this.aviao = aviao;
        aviao.adicionarVoo(this);
    }

    public List<Reserva> getReservas() {
        return new ArrayList<>(reservas);
    }

    @Override
    public String toString() {
        return "Voo{" +
                "id=" + id +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", dataHora=" + dataHora +
                ", aviao=" + aviao +
                ", vagasDisponiveis=" + getVagasDisponiveis() +
                '}';
    }
} 