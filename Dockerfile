FROM openjdk:11
WORKDIR usr/src/code
EXPOSE 8080
COPY target/demo-web-0.0.1-SNAPSHOT.jar demo-web-0.0.1-SNAPSHOT.jar
CMD java -jar demo-web-0.0.1-SNAPSHOT.jar