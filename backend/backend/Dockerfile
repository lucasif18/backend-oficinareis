# Usar imagem base do Java 17 (LTS)
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo pom.xml e o código-fonte
COPY pom.xml .
COPY src ./src

# Instalar o Maven dentro da imagem (para build do projeto)
RUN apt-get update && apt-get install -y maven

# Gerar o .jar do projeto
RUN mvn clean package -DskipTests

# Expor a porta padrão do Spring Boot
EXPOSE 8080

# Executar a aplicação
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]
