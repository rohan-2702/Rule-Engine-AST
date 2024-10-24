# Use the official OpenJDK image as a base
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Maven build output to the container
COPY target/ruleEngine-0.0.1-SNAPSHOT.jar rule-engine.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "rule-engine.jar"]
