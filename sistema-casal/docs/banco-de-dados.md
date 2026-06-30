# 🗄️ Banco de Dados — Sistema Casal

## Objetivo

O banco de dados do Sistema Casal foi projetado para armazenar informações compartilhadas entre o casal e também informações individuais de cada usuário.

O projeto utiliza:

- PostgreSQL
- Supabase
- Spring Data JPA
- Hibernate ORM

---

# Convenções

## Nome das tabelas

Todas as tabelas utilizam o padrão:

snake_case

Exemplo:

usuarios
contas_bancarias
itens_estoque

---

## Nome das colunas

Também seguem snake_case.

Exemplos:

created_at

updated_at

data_validade

quantidade_minima

---

## Chaves Primárias

Todas as tabelas possuem:

id BIGINT

gerado automaticamente.

Exemplo:

id SERIAL PRIMARY KEY

ou

@GeneratedValue(strategy = GenerationType.IDENTITY)

---

# Entidades Principais

## Casais

Representa uma família cadastrada.

Relacionamentos:

1 Casal
↓

N Usuários

↓

N Itens de Estoque

↓

N Listas de Compras

---

Campos

id

nome

created_at

updated_at

---

## Usuários

Representa cada membro do casal.

Campos

id

casal_id

nome

email

created_at

updated_at

Relacionamentos

Um usuário pertence a apenas um casal.

Um casal possui vários usuários.

---

## Bancos

Tabela auxiliar.

Objetivo:

Evitar repetir informações do banco.

Campos

id

nome

codigo_febraban

cor_hex

logo_url

created_at

Relacionamentos

Um banco pode possuir milhares de contas.

---

## Contas Bancárias

Representa as contas individuais dos usuários.

Campos

id

usuario_id

banco_id

tipo_conta

saldo_atual

created_at

updated_at

Relacionamentos

Um usuário pode possuir várias contas.

Cada conta pertence a apenas um banco.

---

## Itens de Estoque

Representa os produtos armazenados na casa.

Campos previstos

id

casal_id

nome

categoria

marca

quantidade

unidade_medida

quantidade_minima

data_validade

data_abertura

dias_validade_apos_aberto

local_armazenamento

created_at

updated_at

Relacionamentos

Os itens pertencem ao casal.

Não pertencem a usuários específicos.

---

# Relacionamentos

Casal

↓

Usuários

↓

Contas Bancárias

↓

Banco

Casal

↓

Itens de Estoque

↓

Lista de Compras

---

# Regras de Modelagem

## 1. Evitar duplicação

Sempre que possível utilizar tabelas auxiliares.

Exemplo:

Banco

Categoria

Unidade de Medida

---

## 2. Datas obrigatórias

Todas as tabelas deverão possuir:

created_at

updated_at

---

## 3. Chaves estrangeiras

Sempre utilizar Foreign Keys para garantir integridade.

Exemplo

usuario_id

casal_id

banco_id

---

## 4. Exclusão

Sempre pensar na regra antes de usar CASCADE.

Nem toda exclusão deve apagar os registros relacionados.

---

# Próximas Tabelas Previstas

Financeiro

movimentacoes

categorias_financeiras

orcamentos_mensais

metas_financeiras

Investimentos

investimentos

ativos

rendimentos

Estoque

categorias_produto

locais_armazenamento

historico_consumo

historico_movimentacao

Compras

listas_compras

itens_lista

Planejamento

tarefas

calendario

eventos

---

# Filosofia do Banco

O banco foi modelado para crescer.

Novos módulos poderão ser adicionados sem necessidade de alterar a estrutura principal.

O Casal continuará sendo a entidade central do sistema.

As informações individuais ficarão ligadas aos Usuários.

As informações compartilhadas permanecerão ligadas ao Casal.