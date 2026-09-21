# =========================
# Stage 1: Build
# =========================
FROM maven:3.9.11-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package -DskipTests


# =========================
# Stage 2: Run
# =========================
FROM eclipse-temurin:17-jre

WORKDIR /app

RUN addgroup --system spring && adduser --system --ingroup spring spring

COPY --from=build /app/target/*.jar app.jar

RUN chown spring:spring app.jar

USER spring

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "app.jar"]