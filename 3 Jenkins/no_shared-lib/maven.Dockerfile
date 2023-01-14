FROM maven:3.6.3-jdk-11-slim as builder
LABEL Name="Dockerfile.account" version="1.5"

COPY . /maven_app
WORKDIR /maven_app
RUN ["mvn", "package", "-DskipTests=true"]

FROM openjdk:8-jre-alpine
LABEL Name="Dockerfile.account" version="1.5"

COPY --from=builder ["/maven_app/bank-microservice/target/*.jar", "/root/app.jar"]
WORKDIR /root

EXPOSE 8083
CMD ["java", "-jar", "app.jar"]

# # keeps container running for debugging => docker exec -it 0ab99d8ab11c /bin/bash
# ENTRYPOINT ["tail", "-f", "/dev/null"]