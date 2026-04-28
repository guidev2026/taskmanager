# 🚀 Task Manager API - Backend Pro

Este projeto é uma API REST robusta para gerenciamento de tarefas, desenvolvida como parte do meu portfólio de desenvolvedor Backend Júnior. A aplicação demonstra o uso prático de **Spring Boot**, persistência de dados complexa e **containerização com Docker**.

## 🎯 Objetivo do Projeto
O foco principal foi construir uma aplicação que seguisse os padrões de mercado, garantindo que o código fosse limpo (Clean Code), seguro e fácil de implantar em qualquer ambiente através do Docker.

---

## 🛠️ Stack Tecnológica

* **Linguagem:** Java 21 (LTS)
* **Framework:** Spring Boot 4.0.6
* **Banco de Dados:** MySQL 8.0
* **ORM:** Spring Data JPA (Hibernate 7.x)
* **Ferramentas de Build:** Maven
* **Infraestrutura:** Docker & Docker Compose
* **Produtividade:** Lombok & Java Records (DTOs)
* **Validação:** Jakarta Bean Validation

---

## 🏗️ Diferenciais Técnicos (O que implementei)

Para elevar o nível deste CRUD, apliquei padrões utilizados em sistemas de grande escala:

1. **Arquitetura em Camadas:** Separação clara entre `Controller` (Entrada), `Service` (Negócio) e `Repository` (Dados).
2. **Padrão DTO com Records:** Uso de Java Records para transferência de dados, garantindo imutabilidade e proteção das entidades do banco de dados.
3. **Handler de Exceções Global:** Implementação de um `@ControllerAdvice` para capturar erros e retornar respostas padronizadas (JSON) para o cliente.
4. **Isolamento com Docker:** Configuração de um ambiente persistente onde o banco de dados MySQL roda em um container, isolando a infraestrutura da máquina local.

---

## 📦 Como Executar o Projeto

### Pré-requisitos
* Docker e Docker Compose instalados.
* JDK 21 instalado (para rodar a aplicação localmente).

### 1. Preparando o Banco de Dados (Docker)
Na raiz do projeto, onde está o arquivo `docker-compose.yml`, execute:
```bash
docker compose up -d
```
*Isso subirá um container MySQL na porta **3307**, configurado para persistir os dados mesmo se o container for parado.*

### 2. Executando a Aplicação
Você pode rodar via sua IDE (IntelliJ/Eclipse) ou pelo terminal:
```bash
./mvnw spring-boot:run
```

A API estará disponível em: `http://localhost:8080/tasks`

---

## 🛣️ Documentação da API (Endpoints)

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/tasks` | Lista todas as tarefas com paginação. |
| `GET` | `/tasks/{id}` | Retorna os detalhes de uma tarefa específica. |
| `POST` | `/tasks` | Cria uma nova tarefa (Valida título e descrição). |
| `PUT` | `/tasks/{id}` | Atualiza os dados de uma tarefa existente. |
| `DELETE` | `/tasks/{id}` | Remove permanentemente uma tarefa. |

### Exemplo de Payload (POST):
```json
{
  "title": "Aprender Docker",
  "description": "Configurar container MySQL para o portfólio",
  "status": "PENDENTE",
  "priority": "ALTA",
  "dueDate": "2026-12-31T23:59:59Z"
}
```

---

## 👨‍💻 Autor

**Guilherme Teixeira Silva** desenvolvedor backend https://www.linkedin.com/in/guilherme-teixeira-0a45a937a | guilherm3teixeir4@gmail.com
