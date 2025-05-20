package com.senai;

import com.senai.controller.SistemaReservas;
import com.senai.model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static final SistemaReservas sistema = new SistemaReservas();
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        boolean executando = true;
        while (executando) {
            exibirMenu();
            int opcao = lerInteiro("Digite a opção desejada: ");
            executando = processarOpcao(opcao);
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== Sistema de Passagens Aéreas ===");
        System.out.println("1 - Cadastrar passageiro");
        System.out.println("2 - Listar passageiros");
        System.out.println("3 - Cadastrar avião");
        System.out.println("4 - Listar aviões");
        System.out.println("5 - Cadastrar voo");
        System.out.println("6 - Listar voos");
        System.out.println("7 - Reservar passagem");
        System.out.println("8 - Listar reservas");
        System.out.println("9 - Sair");
    }

    private static boolean processarOpcao(int opcao) {
        try {
            switch (opcao) {
                case 1 -> cadastrarPassageiro();
                case 2 -> listarPassageiros();
                case 3 -> cadastrarAviao();
                case 4 -> listarAvioes();
                case 5 -> cadastrarVoo();
                case 6 -> listarVoos();
                case 7 -> reservarPassagem();
                case 8 -> listarReservas();
                case 9 -> {
                    System.out.println("Saindo do sistema...");
                    return false;
                }
                default -> System.out.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return true;
    }

    private static void cadastrarPassageiro() {
        System.out.println("\n=== Cadastro de Passageiro ===");
        String nome = lerString("Nome: ");
        String cpf = lerString("CPF: ");
        String email = lerString("Email: ");

        Passageiro passageiro = sistema.cadastrarPassageiro(nome, cpf, email);
        System.out.println("Passageiro cadastrado com sucesso! ID: " + passageiro.getId());
    }

    private static void listarPassageiros() {
        System.out.println("\n=== Lista de Passageiros ===");
        List<Passageiro> passageiros = sistema.listarPassageiros();
        if (passageiros.isEmpty()) {
            System.out.println("Nenhum passageiro cadastrado.");
        } else {
            passageiros.forEach(System.out::println);
        }
    }

    private static void cadastrarAviao() {
        System.out.println("\n=== Cadastro de Avião ===");
        String modelo = lerString("Modelo: ");
        int capacidade = lerInteiro("Capacidade: ");
        String fabricante = lerString("Fabricante: ");

        Aviao aviao = sistema.cadastrarAviao(modelo, capacidade, fabricante);
        System.out.println("Avião cadastrado com sucesso! ID: " + aviao.getId());
    }

    private static void listarAvioes() {
        System.out.println("\n=== Lista de Aviões ===");
        List<Aviao> avioes = sistema.listarAvioes();
        if (avioes.isEmpty()) {
            System.out.println("Nenhum avião cadastrado.");
        } else {
            avioes.forEach(System.out::println);
        }
    }

    private static void cadastrarVoo() {
        System.out.println("\n=== Cadastro de Voo ===");
        String origem = lerString("Origem: ");
        String destino = lerString("Destino: ");
        LocalDateTime dataHora = lerDataHora("Data e Hora (dd/MM/yyyy HH:mm): ");

        listarAvioes();
        int idAviao = lerInteiro("ID do Avião: ");
        Aviao aviao = sistema.buscarAviaoPorId(idAviao);
        if (aviao == null) {
            throw new IllegalArgumentException("Avião não encontrado!");
        }

        Voo voo = sistema.cadastrarVoo(origem, destino, dataHora, aviao);
        System.out.println("Voo cadastrado com sucesso! ID: " + voo.getId());
    }

    private static void listarVoos() {
        System.out.println("\n=== Lista de Voos ===");
        List<Voo> voos = sistema.listarVoos();
        if (voos.isEmpty()) {
            System.out.println("Nenhum voo cadastrado.");
        } else {
            voos.forEach(System.out::println);
        }
    }

    private static void reservarPassagem() {
        System.out.println("\n=== Reserva de Passagem ===");
        listarPassageiros();
        int idPassageiro = lerInteiro("ID do Passageiro: ");
        Passageiro passageiro = sistema.buscarPassageiroPorId(idPassageiro);
        if (passageiro == null) {
            throw new IllegalArgumentException("Passageiro não encontrado!");
        }

        listarVoos();
        int idVoo = lerInteiro("ID do Voo: ");
        Voo voo = sistema.buscarVooPorId(idVoo);
        if (voo == null) {
            throw new IllegalArgumentException("Voo não encontrado!");
        }

        Reserva reserva = sistema.criarReserva(passageiro, voo);
        System.out.println("Reserva realizada com sucesso! ID: " + reserva.getId());
    }

    private static void listarReservas() {
        System.out.println("\n=== Lista de Reservas ===");
        List<Reserva> reservas = sistema.listarReservas();
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
        } else {
            reservas.forEach(System.out::println);
        }
    }

    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }
    }

    private static LocalDateTime lerDataHora(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String dataHoraStr = scanner.nextLine();
                return LocalDateTime.parse(dataHoraStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Use dd/MM/yyyy HH:mm");
            }
        }
    }
} 