FROM adoptopenjdk:11
MAINTAINER Helio Ortega
COPY /target/case-validate-password-1.0.0.RELEASE.jar /
WORKDIR /
ENTRYPOINT java -jar case-validate-password-1.0.0.RELEASE.jar
EXPOSE 8080