FROM openjdk:13-alpine

ARG VERSION=*

COPY target/auth-app-${VERSION}.jar /opt/auth-app.jar

CMD ["java", "-jar", "-Dspring.profiles.active=default", "/opt/auth-app.jar"]