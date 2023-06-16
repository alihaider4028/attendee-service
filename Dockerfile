FROM eclipse-temurin:17

WORKDIR /app

COPY target/attendee-service-0.0.1-SNAPSHOT.jar /app/springboot-attendee.jar

ENTRYPOINT ["java", "-jar", "springboot-attendee.jar"]
