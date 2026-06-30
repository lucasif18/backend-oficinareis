# 🚀 Deploy

## Objetivo

Este documento descreve a infraestrutura utilizada pelo Sistema Casal e os procedimentos para implantação (Deploy) dos serviços.

---

# Arquitetura de Implantação

Cliente (Navegador)

↓

Vue 3 (Front-end)

↓

Spring Boot (API REST)

↓

Supabase (PostgreSQL)

---

# Tecnologias

## Front-end

- Vue 3
- Vite
- Tailwind CSS v4
- Axios

---

## Back-end

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate

---

## Banco

- PostgreSQL
- Supabase

---

# Ambientes

## Desenvolvimento

Front-end

http://localhost:5173

Back-end

http://localhost:8080

Banco

Supabase (Session Pooler)

---

## Produção

Front-end

(Vercel ou Netlify)

Back-end

(Render, Railway ou VPS)

Banco

Supabase

---

# Variáveis de Ambiente

## Backend

application.properties

spring.datasource.url

spring.datasource.username

spring.datasource.password

spring.jpa.hibernate.ddl-auto

spring.jpa.show-sql

---

## Frontend

.env

VITE_API_URL=http://localhost:8080/api

Em produção:

VITE_API_URL=https://api.sistemacasal.com/api

---

# Banco de Dados

A conexão utiliza o Session Pooler do Supabase.

Motivos:

- Compatibilidade IPv4
- Melhor gerenciamento de conexões
- Maior estabilidade

---

# Segurança

Em produção deverão ser utilizados:

HTTPS

JWT Authentication

Refresh Token

CORS restritivo

Rate Limiting

Backup automático

---

# Deploy Futuro

Planejamento:

Front-end

Vercel

↓

Back-end

Render

↓

Banco

Supabase

---

# Docker (Planejamento)

Será disponibilizado:

Dockerfile Front

Dockerfile Back

docker-compose.yml

---

# Integração Contínua

Planejamento futuro:

GitHub Actions

Fluxo:

Push

↓

Build

↓

Testes

↓

Deploy automático

---

# Monitoramento

Planejamento:

Logs

Health Check

Métricas

Alertas

Backup

---

# Objetivos

Garantir que a aplicação seja:

Escalável

Confiável

Reprodutível

Segura

Fácil de implantar