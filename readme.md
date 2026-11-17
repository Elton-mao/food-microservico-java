# Food Payments — Arquitetura de Microsserviços

Projeto pessoal desenvolvido com o objetivo de explorar, na prática, os conceitos de arquitetura de microsserviços utilizando o ecossistema Spring Boot.

A proposta é evoluir uma aplicação inicialmente estruturada como monólito para uma arquitetura distribuída, separando responsabilidades em serviços independentes e explorando os desafios de comunicação, disponibilidade e escalabilidade.

## Arquitetura

A aplicação é organizada em microsserviços independentes, cada um responsável por uma parte do domínio de negócio.

### Componentes

- **Payment Service:** microsserviço responsável pelo processamento e gerenciamento de pagamentos, com banco de dados próprio (MySQL).
- **Order Service:** microsserviço responsável pelo gerenciamento de pedidos e pela comunicação com o serviço de pagamentos.
- **Service Discovery (Eureka):** responsável pelo registro e descoberta dinâmica das instâncias dos serviços.
- **API Gateway:** ponto central de entrada das requisições, responsável pelo direcionamento do tráfego para os microsserviços.

## Conceitos e tecnologias explorados

- **Java e Spring Boot:** desenvolvimento dos microsserviços.
- **Spring Cloud Netflix Eureka:** registro e descoberta de serviços.
- **Spring Cloud Gateway:** gerenciamento e roteamento das requisições.
- **MySQL:** persistência de dados, com banco independente para o serviço de pagamentos.
- **Comunicação síncrona:** integração entre microsserviços por meio de requisições HTTP.
- **Balanceamento de carga:** distribuição de requisições entre múltiplas instâncias de um serviço.
- **Resilience4J:** implementação de Circuit Breaker e Fallback para lidar com falhas e indisponibilidade de serviços.

## Objetivos do projeto

- Compreender os desafios da decomposição de um monólito em microsserviços.
- Aplicar o princípio de banco de dados por serviço.
- Implementar mecanismos de descoberta e comunicação entre serviços.
- Explorar escalabilidade horizontal por meio de múltiplas instâncias.
- Implementar estratégias de tolerância a falhas.
- Entender os benefícios e as complexidades de uma arquitetura distribuída.

## Arquitetura proposta

```text
                 CLIENTE
                    |
                    v
              API GATEWAY
                    |
          +---------+---------+
          |                   |
          v                   v
    ORDER SERVICE       PAYMENT SERVICE
          |                   |
          |                   v
          |              MYSQL DB
          |
          +---- Comunicação HTTP ----+
                                     |
                                     v
                              EUREKA SERVER
                         (Service Discovery)

        RESILIENCE4J
        Circuit Breaker / Fallback
        aplicado nas chamadas entre serviços
```

## Status do projeto

🚧 Em desenvolvimento.

O projeto está sendo construído incrementalmente, com foco na implementação e compreensão dos principais conceitos de uma arquitetura baseada em microsserviços.