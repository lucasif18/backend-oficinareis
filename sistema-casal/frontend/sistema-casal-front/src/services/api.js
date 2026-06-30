import axios from 'axios'

const api = axios.create({
  // Altere a porta se o seu Spring Boot estiver rodando em outra (ex: 8080)
  baseURL: 'http://localhost:8080/api',
  headers: {
    'Content-Type': 'application/json',
  },
})

export default api
