# Stage 1: Build
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests


# Stage 2: Run
FROM openjdk:17-jdk 
# Ganti ke JDK 21
WORKDIR /app
COPY --from=build /app/target/eurekaserver-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app.jar"]
