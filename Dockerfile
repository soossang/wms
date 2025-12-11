FROM eclipse-temurin:17-jdk-alpine
ENV TZ=Asia/Seoul
ARG JAR_FILE=wms-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]