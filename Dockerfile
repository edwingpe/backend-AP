FROM amazoncorretto:11-alpine
MAINTAINER EDWIN
COPY target/backend-0.0.1-SNAPSHOT.jar backend-app.jar
ENTRYPOINT ["java","-jar","/backend-app.jar"]

