FROM openjdk:17-jdk-slim
WORKDIR /student-microservice-a01637218
COPY /target/*.jar student-microservice-a01637218.jar
COPY /src/main/resources/Wallet_javadev /student-microservice-a01637218/Wallet_javadev
ENV TNS_ADMIN=/student-microservice-a01637218/Wallet_javadev
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "student-microservice-a01637218.jar" ]