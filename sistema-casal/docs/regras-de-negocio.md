# 📜 Regras de Negócio — Sistema Casal

## Objetivo

Este documento descreve todas as regras de negócio do Sistema Casal.

Qualquer funcionalidade implementada no Front-end, Back-end ou Banco de Dados deverá respeitar estas regras.

---

# 1. Domínio do Sistema

O sistema possui dois níveis de responsabilidade:

## Escopo Compartilhado (Casal)

São informações pertencentes à casa.

Exemplos:

* Estoque
* Lista de Compras
* Planejamento Financeiro
* Orçamento Mensal
* Metas Financeiras
* Alertas

Ambos os usuários possuem acesso.

---

## Escopo Individual (Usuário)

São informações particulares.

Exemplos:

* Contas Bancárias
* Investimentos
* Cartões
* Histórico Financeiro Individual

Cada usuário administra seus próprios dados.

---

# 2. Estoque Inteligente

Cada produto possui:

* nome
* categoria
* quantidade
* quantidade mínima
* validade original

Opcionalmente poderá possuir:

* data de abertura
* dias de validade após aberto

---

## Regras

Quando:

quantidade <= quantidade mínima

o sistema deverá sugerir automaticamente a inclusão do item na Lista de Compras.

---

Caso um item já exista na lista ativa,

NÃO deverá ser criado novamente.

---

# 3. Controle de Validade

Produtos podem possuir duas formas de validade.

## Validade original

Informada pelo fabricante.

Exemplo

Leite

Validade

15/08/2026

---

## Validade após abertura

Alguns produtos deixam de seguir a validade original após serem abertos.

Exemplo

Molho de tomate

Aberto:

10/06

Consumir em:

5 dias

Descartar:

15/06

O sistema deverá calcular automaticamente essa data.

---

# 4. Status da Validade

Cada item poderá assumir um dos seguintes estados.

## OK

Produto dentro do prazo.

---

## Atenção

Produto vence em até 7 dias.

---

## Vencido

Produto não deve mais ser consumido.

---

# 5. Lista de Compras

Apenas uma lista poderá permanecer ativa.

Ao finalizar:

* estoque é atualizado
* despesa financeira é criada
* saldo da conta bancária é atualizado
* lista é encerrada

---

# 6. Contas Bancárias

Cada conta pertence obrigatoriamente a um Usuário.

Um usuário pode possuir:

* várias contas

Exemplo

Lucas

* Nubank
* Inter
* Caixa

Lane

* Nubank
* C6

Não existe limite de contas.

---

# 7. Planejamento Financeiro

O casal define um orçamento mensal para categorias.

Exemplo

Mercado

R$ 600

Combustível

R$ 450

Lazer

R$ 250

Os valores poderão ser alterados todos os meses.

---

# 8. Carry Over

Caso exista saldo restante no orçamento,

esse saldo poderá ser transportado para o mês seguinte.

Exemplo

Junho

Limite

R$ 600

Gasto

R$ 480

Saldo

R$ 120

Julho

Novo limite

R$ 700

Saldo disponível

R$ 820

---

Caso exista estouro,

o valor excedente reduzirá automaticamente o orçamento do mês seguinte.

---

# 9. Metas Financeiras

O casal poderá cadastrar objetivos.

Exemplos

* Viagem
* Casa própria
* Carro
* Reserva de emergência

Cada meta possuirá:

* valor objetivo
* valor atual
* percentual concluído

---

# 10. Alertas Inteligentes

O sistema poderá emitir alertas como:

* Produto acabando
* Produto vencido
* Produto próximo da validade
* Mercado acima do orçamento
* Conta com saldo insuficiente
* Meta próxima de ser atingida

---

# 11. Regras Futuras

Planejadas para versões posteriores.

* Sugestão automática de receitas utilizando itens próximos da validade.
* Sugestão de compras baseada no histórico.
* Dashboard com indicadores inteligentes.
* IA para previsão de consumo doméstico.
* Comparação de gastos mensais.
* Sugestão de economia baseada nos hábitos do casal.
