# ETAPA 1: Compilação estável usando a imagem do Maven com Temurin 17 embutida
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src

# Executa o comando que junta tudo e gera o arquivo .jar executável
RUN mvn clean package -DskipTests

# ETAPA 2: Cria o ambiente usando a imagem mais compatível e oficial do Java 17
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Pega o arquivo executável gerado na etapa 1 e traz para cá
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]