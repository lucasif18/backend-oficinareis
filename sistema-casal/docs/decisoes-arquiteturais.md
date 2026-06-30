# 🏛️ Decisões Arquiteturais

## Objetivo

Este documento registra todas as decisões importantes tomadas durante o desenvolvimento do Sistema Casal.

Seu propósito é preservar o contexto do projeto, facilitar futuras manutenções e justificar escolhas técnicas.

---

# ADR-001

## Arquitetura Cliente-Servidor

### Decisão

Separar Front-end e Back-end.

### Motivo

Permite evolução independente de cada camada.

### Tecnologias

- Vue 3
- Spring Boot
- PostgreSQL (Supabase)

---

# ADR-002

## Banco de Dados

### Decisão

Utilizar PostgreSQL hospedado no Supabase.

### Motivo

- Banco relacional robusto
- Backup
- Escalabilidade
- Facilidade de deploy

---

# ADR-003

## Uso de DTOs

### Decisão

Nunca retornar entidades JPA diretamente.

### Motivo

- Segurança
- Evita LazyInitializationException
- Evita loops infinitos
- Facilita evolução da API

---

# ADR-004

## Convenções de Banco

### Decisão

Utilizar snake_case.

### Exemplos

usuarios

contas_bancarias

itens_estoque

created_at

updated_at

---

# ADR-005

## Convenções Java

### Decisão

Utilizar camelCase.

### Exemplos

contaBancaria

saldoAtual

dataValidade

---

# ADR-006

## Organização do Front-end

### Decisão

Separação por responsabilidade.

components/

pages/

layouts/

services/

stores/

router/

---

# ADR-007

## Estoque Compartilhado

### Decisão

O estoque pertence ao Casal.

### Justificativa

Os alimentos e produtos pertencem à residência, não a um usuário específico.

Qualquer membro do casal pode:

- adicionar produtos
- retirar produtos
- abrir produtos
- informar validade

---

# ADR-008

## Contas Bancárias

### Decisão

Cada conta pertence a um Usuário.

### Justificativa

Mantém a individualidade financeira.

Mesmo utilizando o sistema em conjunto, cada pessoa pode possuir:

- bancos diferentes
- saldos diferentes
- investimentos diferentes

---

# ADR-009

## Planejamento Financeiro

### Decisão

O orçamento pertence ao Casal.

### Justificativa

As metas financeiras são compartilhadas.

Exemplos:

- reforma
- viagem
- compra de veículo
- reserva de emergência

---

# ADR-010

## Controle de Validade

### Decisão

Todo item do estoque poderá possuir duas datas distintas.

1. Validade do fabricante

2. Validade após aberto

O sistema utilizará automaticamente a data mais restritiva.

---

# ADR-011

## Limite Mensal Inteligente

### Decisão

O casal poderá definir um limite mensal variável.

Exemplo

Junho

R$ 450

Julho

R$ 700

Agosto

R$ 550

O saldo não utilizado poderá ser transferido para o mês seguinte (Carry Over).

Caso haja gasto acima do limite, o excedente será descontado automaticamente do orçamento seguinte.

---

# ADR-012

## Arquitetura Guiada por Documentação

### Decisão

Toda implementação deve ser precedida pela atualização da documentação.

### Benefícios

- Organização
- Facilidade de manutenção
- Melhor comunicação entre desenvolvedores
- Portfólio profissional