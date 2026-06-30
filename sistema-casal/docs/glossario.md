# 📖 Glossário

Este documento reúne os principais termos utilizados durante o desenvolvimento do Sistema Casal.

---

# API

Conjunto de endpoints responsáveis pela comunicação entre Front-end e Back-end.

---

# Axios

Biblioteca JavaScript utilizada para realizar requisições HTTP ao backend.

---

# Banco

Instituição financeira cadastrada no sistema.

Exemplos:

- Nubank
- Banco Inter
- Caixa
- Banco do Brasil

---

# Casal

Entidade principal do sistema.

Representa a unidade familiar.

Possui:

- usuários
- estoque
- lista de compras
- planejamentos

---

# Controller

Camada responsável pelos endpoints REST.

Recebe requisições HTTP e delega para os Services.

---

# CORS

Permite a comunicação entre Front-end e Back-end hospedados em origens diferentes.

---

# DTO (Data Transfer Object)

Objeto utilizado para transportar dados entre Backend e Front-end sem expor diretamente as entidades JPA.

---

# Entity

Classe Java que representa uma tabela do banco de dados.

---

# ENUM

Tipo de dado com valores previamente definidos.

Exemplo:

TipoConta

- CORRENTE
- POUPANCA
- INVESTIMENTO

---

# Hibernate

Framework ORM utilizado pelo Spring Boot para mapear objetos Java para tabelas PostgreSQL.

---

# JPA

Especificação Java utilizada para persistência de dados.

O Hibernate é sua implementação.

---

# JSON

Formato utilizado para troca de informações entre Front-end e Back-end.

---

# Repository

Camada responsável pela comunicação direta com o banco de dados.

---

# REST

Padrão arquitetural utilizado pela API.

---

# Service

Camada responsável pelas regras de negócio.

---

# Supabase

Plataforma utilizada para hospedar o banco PostgreSQL.

---

# Tailwind CSS

Framework CSS baseado em classes utilitárias.

---

# Vue

Framework JavaScript utilizado para construir a interface do sistema.

---

# StatusValidade

Status calculado dinamicamente para um item do estoque.

Valores possíveis:

- VALIDO
- PROXIMO_AO_VENCIMENTO
- VENCIDO
- INDETERMINADO

---

# Carry Over

Saldo restante de um orçamento mensal que é transferido automaticamente para o mês seguinte.

---

# Orçamento Mensal

Valor definido pelo casal para gastos durante determinado mês.

Pode variar entre os meses.

---

# Estoque Inteligente

Módulo responsável pelo controle dos produtos da residência.

Controla:

- quantidade
- validade
- validade após abertura
- estoque mínimo
- alertas

---

# Planejamento Financeiro

Módulo responsável por controlar limites mensais, metas e acompanhamento financeiro do casal.

---

# Chave Primária (Primary Key)

Campo que identifica unicamente um registro em uma tabela.

Exemplo:

id

---

# Chave Estrangeira (Foreign Key)

Campo responsável por criar relacionamento entre tabelas.

Exemplo:

usuario_id

casal_id

banco_id

---

# Session Pooler

Serviço do Supabase responsável pelo gerenciamento eficiente das conexões com o banco de dados.

Foi adotado para garantir compatibilidade com redes IPv4 e maior estabilidade da aplicação.

---

# Git

Sistema de controle de versão utilizado para acompanhar o histórico do projeto.

---

# GitHub

Plataforma onde o código-fonte, documentação e histórico do Sistema Casal são armazenados.

---

# Sprint

Período de desenvolvimento dedicado a um conjunto específico de funcionalidades.

Cada Sprint possui objetivos, entregas e critérios de conclusão.

---

# Arquitetura em Camadas

Modelo adotado pelo projeto para separar responsabilidades em:

- Controller
- Service
- Repository
- Banco de Dados

Essa separação facilita manutenção, testes e evolução do sistema.