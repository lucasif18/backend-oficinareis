<template>
  <div class="min-h-screen bg-gray-100 font-sans text-gray-800">
    <header class="bg-white shadow-sm border-b border-gray-200">
      <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 h-16 flex items-center justify-between">
        <div class="flex items-center space-x-3">
          <div class="bg-indigo-600 text-white p-2 rounded-lg font-bold text-xl shadow-md">🏡</div>
          <span class="text-xl font-bold tracking-tight text-gray-900">Sistema Casal</span>
        </div>
        <nav class="flex space-x-4">
          <span class="text-sm font-medium text-indigo-600 bg-indigo-50 px-3 py-2 rounded-md"
            >Dashboard</span
          >
          <span
            class="text-sm font-medium text-gray-500 hover:text-gray-700 px-3 py-2 cursor-pointer"
            >Despensa</span
          >
          <span
            class="text-sm font-medium text-gray-500 hover:text-gray-700 px-3 py-2 cursor-pointer"
            >Finanças</span
          >
        </nav>
      </div>
    </header>

    <main class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
      <div
        class="mb-8 flex flex-col sm:flex-row sm:items-center sm:justify-between space-y-4 sm:space-y-0"
      >
        <div>
          <h1 class="text-3xl font-extrabold text-gray-900">Olá, Lucas e Lane! 👋</h1>
          <p class="text-sm text-gray-500 mt-1">
            Aqui está o resumo do que está acontecendo na casa hoje.
          </p>
        </div>

        <div>
          <button
            @click="testarSincronizacao"
            class="inline-flex items-center px-4 py-2 border border-transparent text-sm font-medium rounded-md shadow-sm text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 transition-colors"
          >
            🔄 Sincronizar Estoque (Back-end)
          </button>
        </div>
      </div>

      <div class="grid grid-cols-1 md:grid-cols-3 gap-6">
        <div
          class="bg-white p-6 rounded-2xl shadow-sm border border-gray-200 hover:shadow-md transition-shadow"
        >
          <div class="flex items-center justify-between mb-4">
            <span class="text-sm font-bold text-gray-400 uppercase tracking-wider"
              >Saldo Total</span
            >
            <span class="text-2xl text-emerald-500">💰</span>
          </div>
          <h3 class="text-3xl font-bold text-gray-900">R$ 0,00</h3>
          <p class="text-xs text-gray-400 mt-2">Carregando contas do banco...</p>
        </div>

        <div
          class="bg-white p-6 rounded-2xl shadow-sm border border-gray-200 hover:shadow-md transition-shadow"
        >
          <div class="flex items-center justify-between mb-4">
            <span class="text-sm font-bold text-gray-400 uppercase tracking-wider">Despensa</span>
            <span class="text-2xl text-amber-500">🍎</span>
          </div>
          <h3 class="text-3xl font-bold text-gray-900">Tudo Ok</h3>
          <p class="text-xs text-amber-600 mt-2 font-medium">⚠️ Status do estoque monitorado</p>
        </div>

        <div
          class="bg-white p-6 rounded-2xl shadow-sm border border-gray-200 hover:shadow-md transition-shadow"
        >
          <div class="flex items-center justify-between mb-4">
            <span class="text-sm font-bold text-gray-400 uppercase tracking-wider"
              >Status Conexão</span
            >
            <span class="text-2xl text-indigo-500">🔌</span>
          </div>
          <h3 class="text-3xl font-bold text-gray-900">{{ statusConexao }}</h3>
          <p class="text-xs text-gray-400 mt-2">Aguardando clique no botão...</p>
        </div>
      </div>
    </main>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { testeService } from './services/testeService'

const statusConexao = ref('Inativo')

const testarSincronizacao = async () => {
  statusConexao.value = 'Conectando...'
  try {
    // Simulando casal_id = 1 para o teste
    const resposta = await testeService.testarConexao()
    statusConexao.value = 'Sucesso! 🎉'
    alert('Resposta do Java: ' + resposta.data)
  } catch (erro) {
    statusConexao.value = 'Erro ❌'
    console.error(erro)
    alert('Erro ao chamar o back-end! Verifique se o Spring Boot está rodando na porta 8080.')
  }
}
</script>
