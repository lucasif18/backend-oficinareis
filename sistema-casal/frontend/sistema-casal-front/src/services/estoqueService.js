import api from './api'

export const estoqueService = {
  // Dispara o POST para http://localhost:8080/api/estoque-inteligente/sincronizar/{casalId}
  sincronizarEstoque(casalId) {
    return api.post(`/estoque-inteligente/sincronizar/${casalId}`)
  },
}
