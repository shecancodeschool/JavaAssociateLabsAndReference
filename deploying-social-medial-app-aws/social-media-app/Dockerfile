# Use a base image with Java
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the jar file to the image
COPY target/*.jar app.jar

# Expose the port your app listens on (e.g., 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
