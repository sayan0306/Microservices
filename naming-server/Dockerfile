FROM openjdk:21
LABEL authors="sayanmanna0306"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} naming-server.jar
ENTRYPOINT ["java","-jar","/naming-server.jar"]
EXPOSE 8761