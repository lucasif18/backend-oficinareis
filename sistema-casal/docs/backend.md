# 🖥️ Backend — Sistema Casal

## Objetivo

O Back-end é responsável por concentrar todas as regras de negócio do Sistema Casal.

Ele recebe as requisições do Front-end (Vue.js), valida os dados, aplica as regras de negócio, comunica-se com o banco de dados PostgreSQL (Supabase) e devolve respostas em formato JSON.

---

# Tecnologias

* Java 17
* Spring Boot 4
* Spring Web
* Spring Data JPA
* Hibernate
* PostgreSQL
* Supabase
* Maven
* Lombok

---

# Arquitetura

O projeto segue a arquitetura em camadas.

```
Controller
      ↓
Service
      ↓
Repository
      ↓
Banco de Dados
```

Cada camada possui apenas uma responsabilidade.

---

# Estrutura de Pastas

```
backend/

src/main/java/com/financas/sistemacasal/

├── controller
├── dto
├── model
├── repository
├── service
├── config
├── exception
└── SistemaCasalApplication.java
```

---

# Responsabilidade de cada camada

## Controller

Responsável por expor a API REST.

Não possui regra de negócio.

Exemplo:

```
GET /api/usuarios

POST /api/estoque
```

---

## Service

Contém toda a regra de negócio.

Exemplos:

* calcular validade
* verificar estoque mínimo
* validar orçamento
* calcular saldo

Toda decisão do sistema acontece aqui.

---

## Repository

Camada responsável pelo acesso ao banco de dados.

Utiliza Spring Data JPA.

Exemplo:

```
findAll()

findById()

save()

delete()
```

---

## Model (Entity)

Representa uma tabela do banco.

Cada classe anotada com:

```
@Entity
```

corresponde a uma tabela PostgreSQL.

Exemplo:

```
Usuario

Casal

ContaBancaria

ItemEstoque
```

---

## DTO

Os DTOs (Data Transfer Objects) são responsáveis por transportar dados entre o Back-end e o Front-end.

As entidades JPA nunca são enviadas diretamente para o Vue.

Benefícios:

* Segurança
* Desacoplamento
* Facilidade de evolução
* Melhor desempenho

---

# Fluxo de uma Requisição

```
Vue

↓

Axios

↓

Controller

↓

Service

↓

Repository

↓

Banco

↓

Repository

↓

Service

↓

DTO

↓

JSON

↓

Vue
```

---

# Integração com o Banco

Banco utilizado:

PostgreSQL hospedado no Supabase.

A comunicação ocorre através do Hibernate/JPA.

```
Entity

↓

Hibernate

↓

SQL

↓

PostgreSQL
```

---

# Convenções

## Classes

PascalCase

```
Usuario

ContaBancaria

ItemEstoque
```

---

## Métodos

camelCase

```
buscarUsuario()

listarContas()

salvarProduto()
```

---

## Tabelas

snake_case

```
usuarios

casais

contas_bancarias

itens_estoque
```

---

# Padrões Utilizados

* REST API
* Arquitetura em Camadas
* Repository Pattern
* DTO Pattern
* Dependency Injection
* Inversão de Controle (IoC)

---

# Objetivos do Back-end

* Centralizar regras de negócio
* Garantir integridade dos dados
* Fornecer APIs REST
* Persistir dados no PostgreSQL
* Calcular informações inteligentes
* Integrar os módulos do sistema

---

# Evolução Prevista

Próximas implementações:

* Autenticação JWT
* Controle de permissões
* Upload de arquivos
* Logs
* Auditoria
* Testes unitários
* Testes de integração
* Docker
* Deploy em nuvem
