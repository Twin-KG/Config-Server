FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-alpine
COPY --from=build /target/config-server-0.0.1-SNAPSHOT.jar config-server.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","config-server.jar"]