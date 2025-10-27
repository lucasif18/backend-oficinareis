import { createApp } from 'vue'
import App from './App.vue'
import router from './router' // se tiver rotas, senão pode remover essa linha

createApp(App).use(router).mount('#app')
