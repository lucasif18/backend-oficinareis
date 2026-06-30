# 🌐 API REST — Sistema Casal

## Objetivo

Este documento descreve todos os endpoints disponibilizados pelo Back-end Spring Boot.

A API segue o padrão REST e utiliza JSON para comunicação entre Front-end (Vue) e Back-end.

---

# Base URL

Desenvolvimento

http://localhost:8080/api

Produção

https://api.sistemacasal.com/api

---

# Padrão de Resposta

Sucesso

HTTP 200

```json
{
   "id":1,
   "nome":"Lucas"
}
```

---

Erro

HTTP 400

```json
{
   "timestamp":"2026-06-28T19:20",
   "status":400,
   "error":"Bad Request",
   "message":"Dados inválidos."
}
```

---

# Endpoints

## Teste

GET

/api/teste

Objetivo

Verificar comunicação Front ↔ Back.

Resposta

```text
Backend funcionando!
```

---

## Usuários

### Listar contas bancárias

GET

/api/usuarios/{id}/contas

Exemplo

GET

/api/usuarios/1/contas

Resposta

```json
[
   {
      "id":1,
      "tipoConta":"CORRENTE",
      "saldoAtual":1500.00,
      "banco":{
         "id":2,
         "nome":"Nubank",
         "corHex":"#820AD1"
      }
   }
]
```

---

## Bancos

GET

/api/bancos

Resposta

```json
[
   {
      "id":1,
      "nome":"Nubank",
      "codigoFebraban":"260",
      "corHex":"#820AD1"
   }
]
```

---

## Estoque

GET

/api/estoque

Resposta

```json
[
   {
      "id":1,
      "nome":"Leite",
      "quantidadeAtual":2,
      "quantidadeMinima":4,
      "abaixoDoMinimo":true,
      "statusValidade":"PROXIMO_AO_VENCIMENTO"
   }
]
```

---

# Futuros Endpoints

## Casais

GET

POST

PUT

DELETE

---

## Lista de Compras

GET

POST

PUT

DELETE

---

## Orçamento Mensal

GET

POST

PUT

DELETE

---

## Metas Financeiras

GET

POST

PUT

DELETE

---

## Dashboard

GET

/estatisticas

Retornará:

- Gastos do mês
- Economia do mês
- Alertas de estoque
- Produtos vencendo
- Limite disponível
- Metas atingidas

---

# Convenções

Todos os endpoints:

- retornam JSON
- usam DTOs
- nunca retornam entidades JPA diretamente
- seguem padrão REST
- utilizam HTTP Status Codes corretos
