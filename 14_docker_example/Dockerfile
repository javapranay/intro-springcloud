FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/14_docker_example*.jar  spring-config-server.jar
ENTRYPOINT exec java -jar /spring-config-server.jar