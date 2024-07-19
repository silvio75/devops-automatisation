# Utilise l'image OpenJDK 17 comme base
FROM openjdk:17

# Expose le port 8080
EXPOSE 8080

# Copier le fichier JAR dans l'image Docker
COPY target/devops-integration.jar devops-automatisation.jar

# Commande d'entrée pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/devops-automatisation.jar"]