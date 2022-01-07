# syntax=docker/dockerfile:1

#Build stage

FROM maven:latest AS build

COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package

#Package stage
FROM openjdk:11
COPY --from=build /app/target/Practicando-0.0.1-SNAPSHOT.jar /app/target/demo.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/target/demo.jar"]
