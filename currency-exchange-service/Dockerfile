FROM openjdk:21
LABEL authors="sayanmanna0306"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} currency-exchange-service.jar
ENTRYPOINT ["java","-jar","/currency-exchange-service.jar"]
EXPOSE 8000
