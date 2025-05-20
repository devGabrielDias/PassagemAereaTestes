package com.senai.model;

import java.util.ArrayList;
import java.util.List;

public class Aviao {
    private int id;
    private String modelo;
    private int capacidade;
    private String fabricante;
    private List<Voo> voos;

    public Aviao(int id, String modelo, int capacidade, String fabricante) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero");
        }
        this.id = id;
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.fabricante = fabricante;
        this.voos = new ArrayList<>();
    }

    public void adicionarVoo(Voo voo) {
        this.voos.add(voo);
    }

    public void removerVoo(Voo voo) {
        this.voos.remove(voo);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero");
        }
        this.capacidade = capacidade;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public List<Voo> getVoos() {
        return new ArrayList<>(voos);
    }

    @Override
    public String toString() {
        return "Aviao{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", capacidade=" + capacidade +
                ", fabricante='" + fabricante + '\'' +
                '}';
    }
} 