# syntax=docker/dockerfile:1

FROM openjdk:11

COPY Executable.jar /

EXPOSE 8080

CMD java -jar Executable.jar
