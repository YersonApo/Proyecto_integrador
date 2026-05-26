# Etapa 1: Build
FROM eclipse-temurin:21 AS builder
WORKDIR /app
COPY . .
RUN chmod +x gradlew
RUN ./gradlew build -x test

# Etapa 2: Imagen final liviana
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/build/libs/Proyecto_integrador-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
