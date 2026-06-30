import api from './api'

export const testeService = {
  testarConexao() {
    return api.get('/teste')
  },
}
