FROM amazoncorretto:8-alpine-jdk
MAINTAINER EDWIN
EXPOSE 8080
COPY target/backend-0.0.1-SNAPSHOT.jar backend-app.jar
ENTRYPOINT ["java","-jar","/backend-app.jar"]

