FROM openjdk:8-jre-alpine

LABEL Name="aline-bank-microservice" version="1.6"

COPY ["bank-microservice/target/bank-microservice-0.1.0.jar", "app.jar"]

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "/app.jar"]