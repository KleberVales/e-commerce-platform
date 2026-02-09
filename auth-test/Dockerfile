# Estágio de Build
# Gradle 8.5 é o ideal para Spring Boot 3.2.2
FROM gradle:8.5-jdk21 AS build
WORKDIR /app

# Copia apenas os arquivos de configuração primeiro para cache
COPY build.gradle settings.gradle ./
COPY src ./src

# Executa o build
RUN gradle clean bootJar -x test --no-daemon

# Estágio de Execução
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Garante que o JAR seja copiado corretamente
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8081

# Força a porta 8081 para não conflitar com o outro microserviço
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=8081"]