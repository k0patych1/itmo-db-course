FROM eclipse-temurin:21
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dapp.queries=${QUERIES}", "-Dapp.repeat-count=${REPEAT_COUNT}", "-jar", "/app.jar"]