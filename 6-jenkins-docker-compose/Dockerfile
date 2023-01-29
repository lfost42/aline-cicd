FROM openjdk:8-jre-alpine

LABEL Name="aline-account-microservice" version="1.6"

COPY ["account-microservice/target/account-microservice-0.1.0.jar", "app.jar"]

EXPOSE 8072

ENTRYPOINT ["java", "-jar", "/app.jar"]