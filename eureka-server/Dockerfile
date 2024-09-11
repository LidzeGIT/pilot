# First stage: complete build environment
FROM maven:3.8.3-openjdk-17 AS builder
WORKDIR /app
COPY ./pom.xml ./pom.xml
COPY ./src ./src/
RUN mvn clean package  -DskipTests

# Second stage: minimal runtime environment
FROM openjdk:17-jdk as app
WORKDIR /app
COPY --from=builder /app/target/eureka-server-0.0.1-SNAPSHOT.jar .
EXPOSE 8761
CMD ["java", "-jar", "eureka-server-0.0.1-SNAPSHOT.jar"]