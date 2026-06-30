# 🏛️ Arquitetura do Sistema — Sistema Casal

# Objetivo

Este documento descreve a arquitetura geral do Sistema Casal, apresentando a organização das camadas, o fluxo de comunicação entre elas e as responsabilidades de cada módulo.

O objetivo é manter uma arquitetura limpa, desacoplada e escalável, facilitando futuras manutenções e novas funcionalidades.

---

# Arquitetura Geral

O projeto segue a arquitetura em camadas (Layered Architecture), amplamente utilizada em aplicações Java com Spring Boot.

```
                Usuário

                   │

                   ▼

          Front-end (Vue 3)

                   │
             HTTP / JSON
                Axios

                   │

                   ▼

      Controllers (Spring Boot)

                   │

                   ▼

           Services (Regras)

                   │

                   ▼

         Repositories (JPA)

                   │

                   ▼

      PostgreSQL (Supabase)
```

Cada camada possui uma única responsabilidade.

Nenhuma camada acessa diretamente outra que não seja sua vizinha.

---

# Tecnologias

## Front-end

* Vue.js 3
* Vite
* Tailwind CSS v4
* Axios
* Vue Router
* Pinia

Responsabilidades:

* Interface do usuário
* Navegação
* Consumo da API
* Validação básica dos formulários

---

## Back-end

* Java 17
* Spring Boot 4
* Spring Data JPA
* Hibernate

Responsabilidades:

* Regras de negócio
* Segurança
* Processamento
* Persistência dos dados

---

## Banco de Dados

* PostgreSQL
* Supabase

Responsabilidades:

* Armazenamento
* Integridade dos dados
* Relacionamentos

---

# Organização do Back-end

```
controller/

service/

repository/

model/

dto/

config/

exception/
```

## Controller

Recebe as requisições HTTP.

Nunca contém regras de negócio.

Responsável apenas por:

* receber dados
* chamar o Service
* devolver resposta

---

## Service

É o cérebro do sistema.

Toda regra de negócio deve ficar aqui.

Exemplos:

* verificar orçamento
* atualizar estoque
* gerar lista de compras
* validar saldo
* calcular metas

---

## Repository

Responsável apenas pelo acesso ao banco.

Nunca contém regra de negócio.

Utiliza Spring Data JPA.

---

## Model

Representa as entidades do banco.

Exemplo:

Usuario

ContaBancaria

Casal

Banco

---

## DTO

Camada responsável pela comunicação com o Front-end.

Nunca retornaremos entidades JPA diretamente.

Vantagens:

* segurança
* desempenho
* desacoplamento
* facilidade de evolução

---

# Organização do Front-end

```
src/

components/

views/

services/

router/

stores/

assets/
```

## Components

Componentes reutilizáveis.

Exemplo:

CardSaldo

Sidebar

TabelaContas

BotaoSalvar

---

## Views

Representam páginas completas.

Exemplo:

Dashboard

Finanças

Despensa

Compras

---

## Services

Comunicação com a API.

Utiliza Axios.

Exemplo:

usuarioService

contaService

estoqueService

---

## Router

Gerencia as rotas.

---

## Stores

Gerencia estados globais utilizando Pinia.

---

# Fluxo da Informação

Exemplo:

Usuário clica em

"Adicionar Conta"

↓

Vue envia requisição

↓

Controller recebe

↓

Service valida

↓

Repository salva

↓

Banco grava

↓

Repository retorna

↓

Service processa

↓

Controller responde

↓

Vue atualiza a tela

---

# Modelo de Domínio

## Casal

Responsável por informações compartilhadas.

Possui:

* usuários
* estoque
* listas de compras
* orçamento
* metas

---

## Usuário

Cada usuário possui:

* contas bancárias
* cartões
* investimentos
* lançamentos financeiros

---

## Banco

Cadastro das instituições financeiras.

Relaciona-se com várias contas bancárias.

---

## Conta Bancária

Pertence a apenas um usuário.

Relaciona-se com um banco.

---

## Estoque

Pertence ao casal.

Controla:

* produtos
* quantidade
* estoque mínimo

---

## Lista de Compras

Pertence ao casal.

Pode ser gerada automaticamente pelo estoque.

---

## Lançamentos

Representam entradas e saídas financeiras.

Podem atualizar automaticamente:

* saldo
* orçamento
* metas

---

# Comunicação entre os Módulos

```
Estoque

↓

Lista de Compras

↓

Compra Finalizada

↓

Lançamento Financeiro

↓

Atualização da Conta

↓

Atualização do Orçamento

↓

Atualização das Metas
```

Essa integração é um dos principais diferenciais do Sistema Casal.

---

# Boas Práticas Adotadas

✅ Arquitetura em Camadas

✅ DTOs

✅ REST API

✅ Separação de responsabilidades

✅ Banco normalizado

✅ Código desacoplado

✅ Regras de negócio centralizadas

---

# Visão de Longo Prazo

O Sistema Casal foi projetado para crescer de forma modular.

Módulos previstos:

* Finanças
* Estoque
* Lista de Compras
* Metas
* Orçamento Inteligente
* Investimentos
* Cartões
* Dashboard Analítico
* Inteligência Artificial

Cada módulo poderá evoluir independentemente, mantendo a arquitetura organizada e preparada para novas funcionalidades.
