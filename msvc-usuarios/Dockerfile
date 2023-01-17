FROM openjdk:17.0.2

WORKDIR /app

COPY ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar /app

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]