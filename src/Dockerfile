FROM gradle:7.3.0-jdk8 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:8

EXPOSE 8103

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/microservice-registry-0.0.1-SNAPSHOT.jar /app/microservice-registry.jar

ENTRYPOINT ["java","-jar","/app/microservice-registry.jar"]