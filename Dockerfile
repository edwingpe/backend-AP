FROM amazoncorretto:19
MAINTAINER EDWIN
EXPOSE 8080
COPY target/backend-0.0.1-SNAPSHOT.jar backend-app.jar
ENTRYPOINT ["java","-jar","/backend-app.jar"]

