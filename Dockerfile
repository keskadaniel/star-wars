FROM openjdk:11-jre-slim
EXPOSE 8080
RUN mkdir /app
COPY build/libs/*.jar /app/star-wars-application.jar
ENTRYPOINT ["java","-jar","/app/star-wars-application.jar"]