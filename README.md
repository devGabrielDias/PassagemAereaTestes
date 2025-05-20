# Sistema de Passagens Aéreas

Este projeto é a resolução de uma atividade acadêmica que propõe o desenvolvimento de um sistema de passagens aéreas utilizando Java e arquitetura MVC, com foco em testes automatizados e cobertura de código.

## O que a atividade resolve?
O sistema implementa as principais regras de negócio de uma companhia aérea, permitindo:
- Cadastro e validação de passageiros
- Cadastro de aviões
- Cadastro de voos
- Reserva de passagens
- Listagem de entidades

## Casos de Uso Atendidos
Abaixo estão os casos de teste/casos de uso propostos na atividade e que foram resolvidos neste sistema:

### 1. Validação de Passageiros
- Testar CPF válido (exemplo: "52998224725") → Deve retornar true
- Testar CPF inválido (exemplo: "12345678900") → Deve retornar false
- Testar e-mail válido (exemplo: "ana.souza@email.com") → Deve retornar true
- Testar e-mail inválido (exemplo: "ana.souza@com") → Deve retornar false

### 2. Cadastro de Passageiros
- Cadastrar passageiro com dados válidos → Deve adicionar à lista
- Tentar cadastrar passageiro com CPF inválido → Deve falhar ou lançar exceção

### 3. Cadastro de Aviões
- Cadastrar avião com modelo e capacidade válidos → Deve ser salvo corretamente
- Tentar cadastrar avião com capacidade zero → Deve lançar exceção ou falhar
- Tentar cadastrar avião com capacidade negativa → Deve lançar exceção ou falhar

### 4. Cadastro de Voos
- Cadastrar voo com origem, destino, data e avião válido → Deve ser salvo corretamente
- Tentar cadastrar voo sem avião associado → Deve lançar exceção ou falhar

### 5. Reserva de Passagens
- Criar reserva com vagas disponíveis → Deve ser realizada com sucesso
- Criar reserva quando todas as vagas estiverem ocupadas → Deve falhar ou lançar exceção
- Criar reserva duplicada para o mesmo passageiro e voo → Deve impedir ou notificar (se implementado)

### 6. Listagens
- Listar passageiros após 3 cadastros → Deve retornar 3 registros
- Listar aviões após 2 cadastros → Deve retornar 2 registros
- Listar voos após 1 cadastro → Deve retornar 1 registro com dados do avião
- Listar reservas após 2 registros → Deve retornar 2 reservas com passageiro e voo

## Testes Automatizados
Todos os casos acima são validados por testes automatizados, garantindo a cobertura e a robustez do sistema.

---

Sinta-se à vontade para clonar, rodar e adaptar este projeto para fins acadêmicos ou de aprendizado!

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