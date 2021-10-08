FROM adoptopenjdk:11
MAINTAINER Helio Ortega
COPY /target/case-validate-password-0.0.1-SNAPSHOT.jar /
WORKDIR /
ENTRYPOINT java -jar case-validate-password-0.0.1-SNAPSHOT.jar
EXPOSE 8080