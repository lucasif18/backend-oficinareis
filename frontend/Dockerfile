# ==============================
# Etapa 1 — Build do projeto Vue
# ==============================
FROM node:18 AS build-stage

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos de dependência e instala
COPY package*.json ./
RUN npm ci

# Copia o restante do código e executa o build
COPY . .
RUN npm run build

# ==============================
# Etapa 2 — Servindo com Nginx
# ==============================
FROM nginx:stable-alpine AS production-stage

# Remove a página padrão do Nginx
RUN rm -rf /usr/share/nginx/html/*

# Copia os arquivos do build do Vue
COPY --from=build-stage /app/dist /usr/share/nginx/html

# Copia o arquivo de configuração do Nginx (opcional, veja abaixo)
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Expõe a porta
EXPOSE 80

# Mantém o Nginx rodando
CMD ["nginx", "-g", "daemon off;"]
