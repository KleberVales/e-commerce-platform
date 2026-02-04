# Usar imagem base do JDK para compilar
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copiar arquivos do projeto
COPY . .

# Compilar usando Gradle
RUN ./gradlew clean build -x test

# Usar JRE para rodar a aplicação
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiar o JAR gerado do estágio anterior
COPY --from=build /app/build/libs/auth-service-*.jar app.jar

# Expor a porta do serviço
EXPOSE 8082

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
