FROM openjdk:8-jre-slim
COPY ./target/todoapp-0.0.1-SNAPSHOT.jar /opt/app.jar
CMD [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/opt/app.jar" ]
