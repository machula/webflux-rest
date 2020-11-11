FROM adoptopenjdk/openjdk11:jdk-11.0.5_10-alpine
RUN apk add --no-cache maven
ADD . /src
WORKDIR /src
RUN ./mvnw package
ENV MONGO_HOST=${MONGO_HOST}
ENV MONGO_PORT=${MONGO_PORT}
ENV MONGO_DATABASE=${MONGO_DATABASE}

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]