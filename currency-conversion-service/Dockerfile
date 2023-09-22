FROM openjdk:21
LABEL authors="sayanmanna0306"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} currency-conversion-service.jar
ENTRYPOINT ["java","-jar","/currency-conversion-service.jar"]
EXPOSE 8100
