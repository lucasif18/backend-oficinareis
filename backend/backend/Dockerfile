# ===== Etapa 1: Build do projeto =====
FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar os arquivos do projeto
COPY pom.xml .
COPY src ./src

# Compilar o projeto (sem rodar testes)
RUN mvn clean package -DskipTests

# ===== Etapa 2: Runtime =====
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiar o jar gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expor a porta da aplicação
EXPOSE 8080

# Comando de execução
ENTRYPOINT ["java", "-jar", "app.jar"]
