#base container with java 17 runtime for running the java application
FROM openjdk:17-jdk-slim

# Copying application jar into the docker Images
COPY target/Cards-0.0.1-SNAPSHOT.jar Cards-0.0.1-SNAPSHOT.jar

MAINTAINER SridharVadla

#executes the application
ENTRYPOINT ["java", "-jar", "Cards-0.0.1-SNAPSHOT.jar"]




