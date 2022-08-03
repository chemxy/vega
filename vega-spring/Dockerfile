#
# Build stage
#
FROM openjdk:14.0.2 as build
WORKDIR /workspace/app

COPY mvnw.cmd .
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src .src
ARG JAR_FILE=/target/venus-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} .
ADD ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
