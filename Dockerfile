#TO TO: build gradle
#FROM gradle:4.7.0-jdk8-alpine AS build
#COPY --chown=gradle:gradle . /home/gradle/src
#WORKDIR /home/gradle/src
#RUN gradle build --no-daemon

FROM openjdk:11-jre-slim
EXPOSE 8080
RUN mkdir /app
COPY build/libs/*.jar /app/star-wars-application.jar
ENTRYPOINT ["java","-jar","/app/star-wars-application.jar"]