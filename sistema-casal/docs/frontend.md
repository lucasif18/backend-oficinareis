# 🎨 Front-end — Sistema Casal

## Objetivo

O Front-end é responsável por oferecer uma experiência intuitiva, moderna e responsiva para o casal gerenciar finanças, estoque doméstico, listas de compras e metas financeiras.

Toda comunicação com o servidor ocorre exclusivamente através da API REST.

---

# Tecnologias

- Vue 3
- Vite
- Tailwind CSS v4
- Axios
- JavaScript (futuramente TypeScript)
- Vue Router
- Pinia (planejado)

---

# Estrutura do Projeto

```
src/

components/
pages/
layouts/
services/
assets/
router/
stores/
composables/
utils/

App.vue
main.js
```

---

# Responsabilidades

## Components

Componentes reutilizáveis.

Exemplos:

- Botões
- Cards
- Inputs
- Modal
- Barra de progresso
- Alertas

---

## Pages

Representam telas completas.

Exemplos:

Dashboard

Estoque

Lista de Compras

Contas Bancárias

Planejamento Financeiro

Metas

Configurações

---

## Layouts

Estrutura comum das páginas.

Exemplo:

Navbar

Sidebar

Footer

Área principal

---

## Services

Camada responsável pelas chamadas HTTP.

Exemplo

api.js

usuarioService.js

estoqueService.js

contaService.js

orcamentoService.js

---

## Router

Centraliza todas as rotas.

Exemplo

/

/dashboard

/estoque

/contas

/compras

/metas

---

## Stores

Estado global da aplicação.

Inicialmente poderá conter:

Usuário logado

Casal

Tema

Notificações

---

# Fluxo da Aplicação

```
Usuário

↓

Página Vue

↓

Componentes

↓

Service

↓

Axios

↓

Spring Boot

↓

Supabase
```

---

# Padrões Visuais

Interface limpa

Poucas cores

Pouco texto

Cards grandes

Ícones intuitivos

Responsividade Mobile First

---

# Sistema de Alertas

O Front-end deverá destacar visualmente:

🟢 Produto disponível

🟡 Produto próximo do vencimento

🔴 Produto vencido

🟠 Estoque abaixo do mínimo

🔵 Meta financeira atingida

🟣 Limite mensal próximo do fim

---

# Tema

Modo Claro

Modo Escuro

(alternância futura)

---

# Componentes Planejados

FinanceCard

ContaCard

BancoBadge

ProdutoCard

MetaCard

ResumoMensalCard

GraficoDespesas

GraficoCategorias

ListaComprasCard

NotificacaoCard

---

# Comunicação

Toda comunicação utilizará:

Axios

JSON

DTOs

Nunca acessar o banco diretamente.

---

# Objetivos de UX

O sistema deve permitir que qualquer membro do casal consiga utilizar todas as funcionalidades sem treinamento prévio.

As informações mais importantes devem estar disponíveis em até dois cliques.