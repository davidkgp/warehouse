FROM openjdk:8-jdk-alpine
EXPOSE 8099
ARG JAR_FILE=target/warehouse-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]