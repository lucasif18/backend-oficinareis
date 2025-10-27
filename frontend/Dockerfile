# Etapa 1 — Build do projeto Vue
FROM node:18 AS build-stage
WORKDIR /app

# Copia os arquivos de configuração e instala dependências
COPY package*.json ./
RUN npm install

# Copia o restante dos arquivos e faz o build
COPY . .
RUN npm run build

# Etapa 2 — Servindo o frontend com Nginx
FROM nginx:stable-alpine AS production-stage

# Copia o build do Vue para o diretório padrão do Nginx
COPY --from=build-stage /app/dist /usr/share/nginx/html

# Expõe a porta padrão do Nginx
EXPOSE 80

# Comando padrão do Nginx
CMD ["nginx", "-g", "daemon off;"]
