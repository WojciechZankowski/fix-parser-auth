FROM openjdk:13-alpine

COPY target/auth-app-*.jar /opt/auth-app.jar

CMD ["java", "-jar", "-Dspring.profiles.active=default", "/opt/auth-app.jar"]