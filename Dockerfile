# Use a imagem base do OpenJDK
FROM openjdk:17-jre-slim

# Copie o arquivo JAR do aplicativo para o contêiner
COPY target/my-spring-app.jar /app.jar

# Defina a porta em que o aplicativo irá ouvir
EXPOSE 8081

# Comando para executar o aplicativo Spring Boot
CMD ["java", "-jar", "/app.jar"]