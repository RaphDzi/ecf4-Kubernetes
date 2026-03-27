# ─────────────────────────────────────────
# Stage 1 : Build
# ─────────────────────────────────────────
FROM maven:3.8.6-openjdk-11-slim AS builder

WORKDIR /app

# Copier uniquement le pom.xml d'abord pour profiter du cache des dépendances Maven
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copier le source et builder
COPY src ./src
RUN mvn clean package -DskipTests -B

# ─────────────────────────────────────────
# Stage 2 : Runtime
# ─────────────────────────────────────────
FROM eclipse-temurin:11-jre AS runtime

# Métadonnées
LABEL maintainer="ecommerce-team"
LABEL service="common-data-service"

# Créer un utilisateur non-root pour la sécurité
RUN groupadd -r appgroup && useradd -r -g appgroup appuser

WORKDIR /app

# Copier uniquement le JAR depuis le stage builder
COPY --from=builder /app/target/common-data-service.jar app.jar

# Changer le propriétaire
RUN chown appuser:appgroup app.jar

USER appuser

EXPOSE 9000

# Healthcheck via Spring Boot Actuator
HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
  CMD curl -f http://localhost:9000/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]
