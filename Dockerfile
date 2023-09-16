FROM openjdk:17-jdk-slim as build

#Information around who maintains the image
MAINTAINER zayarlinnnaung

# Add the application's jar to the container
COPY target/config-server-0.0.1-SNAPSHOT.jar config-server.jar

#execute the application
ENTRYPOINT ["java","-jar","/config-server.jar"]