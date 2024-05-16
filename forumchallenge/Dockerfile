FROM maven:3.8.1-openjdk-17
WORKDIR /project
COPY target/forumchallenge-0.0.1-SNAPSHOT.jar /project/app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]