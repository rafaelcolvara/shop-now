FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
EXPOSE "8080"


ENTRYPOINT ["java","-jar","/opt/app/app.jar"]

