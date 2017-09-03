FROM openjdk:jdk AS build
WORKDIR /tmp
ADD . /tmp
RUN ./gradlew build

FROM openjdk:jre
COPY --from=build /tmp/build/libs/spring-rest-api-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
HEALTHCHECK CMD curl -v --silent http://localhost:8080/health 2>&1 | grep UP