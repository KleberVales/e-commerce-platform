# Etapa de build
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copia tudo para dentro do container
COPY . .

# Dá permissão de execução ao gradlew
RUN chmod +x gradlew

# Compila o projeto com Gradle
RUN ./gradlew clean build -x test

# Etapa final
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copia o JAR gerado
COPY --from=build /app/build/libs/product-service-*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
