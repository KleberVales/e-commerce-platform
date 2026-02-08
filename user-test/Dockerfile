# Usando a imagem 'latest' para garantir que venha uma versão 8.12+ ou 9.x
FROM gradle:jdk21 AS build
WORKDIR /app

# O resto continua igual...
COPY build.gradle settings.gradle ./
COPY src ./src

RUN gradle clean bootJar -x test

# Estágio de Execução
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]