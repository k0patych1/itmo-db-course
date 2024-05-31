FROM eclipse-temurin:21
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dapp.generation-data-size=${GENERATION_DATA_SIZE}", "-jar", "/app.jar"]