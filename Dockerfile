FROM amazoncorretto:8-alpine-jdk
MAINTAINER EDWIN
COPY target/backend-0.0.1-SNAPSHOT.jar backend-app.jar
ENTRYPOINT ["java","-jar","/backend-app.jar"]

