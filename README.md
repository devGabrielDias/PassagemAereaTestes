# Sistema de Passagens Aéreas

Este é um sistema de gerenciamento de passagens aéreas desenvolvido em Java seguindo o padrão de arquitetura MVC (Model-View-Controller).

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

```
src/
├── main/
│   └── java/
│       └── com/
│           └── senai/
│               ├── model/
│               │   ├── Passageiro.java
│               │   ├── Aviao.java
│               │   ├── Voo.java
│               │   └── Reserva.java
│               ├── controller/
│               │   └── SistemaReservas.java
│               └── MainApp.java
└── test/
    └── java/
        └── com/
            └── senai/
                ├── model/
                │   ├── PassageiroTest.java
                │   ├── AviaoTest.java
                │   ├── VooTest.java
                │   └── ReservaTest.java
                └── controller/
                    └── SistemaReservasTest.java
```

## Funcionalidades

O sistema permite:

1. Cadastrar e listar passageiros
2. Cadastrar e listar aviões
3. Cadastrar e listar voos
4. Realizar e listar reservas de passagens

## Requisitos

- Java 11 ou superior
- Maven

## Como Executar

1. Clone o repositório
2. Navegue até o diretório do projeto
3. Execute o comando:
   ```bash
   mvn clean install
   ```
4. Execute a aplicação:
   ```bash
   mvn exec:java -Dexec.mainClass="com.senai.MainApp"
   ```

## Testes

Para executar os testes unitários:

```bash
mvn test
```

## Validações Implementadas

### Passageiro
- Validação de CPF
- Validação de e-mail

### Avião
- Capacidade deve ser maior que zero

### Voo
- Deve estar vinculado a um avião
- Cálculo de vagas disponíveis

### Reserva
- Verificação de disponibilidade de vagas
- Validação de passageiro e voo

## Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request 