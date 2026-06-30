# 🗺️ Roadmap & Memória do Projeto — Sistema Casal

## 🎯 Objetivo

Desenvolver uma plataforma web para gestão doméstica inteligente de casais, integrando finanças pessoais, orçamento familiar, estoque doméstico, listas de compras e automações que auxiliem na tomada de decisões financeiras.

O projeto está sendo desenvolvido como portfólio acadêmico e profissional, seguindo boas práticas de arquitetura de software e desenvolvimento Full Stack.

---

# 🚀 Arquitetura Geral

## Front-end

* Vue.js 3
* Vite
* Tailwind CSS v4
* Axios
* Vue Router
* Pinia

Porta padrão:

5173

---

## Back-end

* Java 17
* Spring Boot 4
* Spring Data JPA
* Hibernate

Porta padrão:

8080

---

## Banco de Dados

* PostgreSQL
* Supabase
* Session Pooler (IPv4)

---

# 🏛️ Escopo do Domínio

## Casal (Dados Compartilhados)

Responsável pelos módulos compartilhados da casa.

Exemplos:

* Estoque
* Lista de Compras
* Planejamento Financeiro
* Orçamento Mensal
* Metas Financeiras
* Reservas da Casa

---

## Usuário (Dados Individuais)

Cada usuário possui seus próprios dados financeiros.

Exemplos:

* Contas Bancárias
* Cartões
* Investimentos
* Salário
* Histórico Financeiro

---

## Banco

Cadastro único das instituições financeiras.

Exemplos:

* Nubank
* Banco Inter
* Caixa
* Banco do Brasil
* Santander

---

## Conta Bancária

Cada conta pertence a um único usuário.

Uma conta possui:

* banco
* tipo
* saldo
* movimentações

---

# 📌 Convenções do Projeto

## Tecnologias

* Java 17
* Spring Boot 4
* PostgreSQL
* Supabase
* Vue 3
* Tailwind CSS v4

---

## Padrões

camelCase

Utilizado em:

* atributos Java
* variáveis JavaScript
* métodos

---

snake_case

Utilizado nas colunas do PostgreSQL.

---

PascalCase

Utilizado em:

* Classes Java
* Componentes Vue

---

REST API

Endpoints seguindo padrão REST.

---

DTO obrigatório

As entidades JPA nunca serão retornadas diretamente pela API.

Toda comunicação com o Front será realizada através de DTOs.

---

# 🏁 Status das Sprints

## 🟩 Sprint 1 — Infraestrutura e Conectividade

Status:

✅ Concluída

Entregas:

* Configuração do Spring Boot
* Configuração do Maven
* Configuração do Vue
* Configuração do Tailwind
* Configuração do Axios
* Integração Front ↔ Back
* Resolução do problema de CORS
* Teste de comunicação via TesteController

Marco:

🎉 Front-end e Back-end comunicando com sucesso.

---

## 🟨 Sprint 2 — Core Relacional e Finanças Individuais

Status:

🚧 Em andamento

Entregas concluídas:

* Modelagem inicial do banco
* Migração da Conta Bancária para Usuário
* Entidades JPA
* Repositories
* Services
* Controllers
* Endpoint GET /api/usuarios/{id}/contas

Em desenvolvimento:

* DTOs
* Integração da API com o Vue
* Listagem dinâmica das contas

---

## 🟦 Sprint 3 — Planejamento Financeiro Inteligente

Status:

📋 Planejado

Objetivos:

* CRUD de Orçamentos Mensais
* Carry Over (saldo acumulado)
* Limite Mensal configurável
* Barra de progresso do orçamento
* Alertas de estouro
* Simulador de compras

---

## 🟪 Sprint 4 — Despensa Inteligente

Planejado

Objetivos:

* Cadastro de produtos
* Estoque mínimo
* Alertas automáticos
* Consumo médio
* Geração automática da lista de compras

---

## 🟧 Sprint 5 — Inteligência Financeira

Planejado

Objetivos:

* Sugestões automáticas
* Projeção de gastos
* Detecção de despesas incomuns
* Comparação entre meses
* Recomendações de economia

---

# 💡 Ideias Aprovadas para o Projeto

## Carry Over

O orçamento mensal poderá acumular saldo.

Se sobrar dinheiro:

O saldo será incorporado ao orçamento do mês seguinte.

Se faltar dinheiro:

O déficit será descontado do orçamento seguinte.

---

## Limite Inteligente

Antes de finalizar uma compra, o sistema verificará automaticamente:

* orçamento disponível
* valor da compra
* saldo restante

Caso ultrapasse o limite, será exibido um alerta.

---

## Metas Financeiras

O casal poderá criar metas como:

* viagem
* carro
* casa
* emergência
* investimentos

---

## Estoque Inteligente

Quando um produto atingir o estoque mínimo:

↓

Adicionar automaticamente na lista de compras.

---

# 📅 Próximas Entregas

1. Criar camada de DTOs.
2. Integrar API de Contas ao Vue.
3. Componentizar o Dashboard.
4. Criar tela de Contas Bancárias.
5. Criar tela da Despensa.
6. Criar módulo de Orçamento Mensal.

---

# 🛠️ Últimas Decisões Arquiteturais

✅ Conta Bancária pertence ao Usuário.

✅ Estoque pertence ao Casal.

✅ Lista de Compras pertence ao Casal.

✅ Bancos possuem cadastro próprio.

✅ API retorna apenas DTOs.

✅ Front-end e Back-end permanecem desacoplados.

---

**Última atualização:** Junho de 2026.
