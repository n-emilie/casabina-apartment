FROM ubuntu:latest
LABEL authors="Emilie"

ENTRYPOINT ["top", "-b"]

# Utilisation d'une image de base avec Java 21
FROM openjdk:21-jdk-slim

# Définition du répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR généré dans le conteneur
COPY target/apartment-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel Spring Boot tourne
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
