FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/msvc-usuarios

#COPY ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar /app
COPY ./pom.xml /app
COPY ./msvc-usuarios/.mvn ./.mvn
COPY ./msvc-usuarios/mvnw .
COPY ./msvc-usuarios/pom.xml .

#ESTE COMANDO SOLO HA SIDO NECESARIO PARA CONVERTIR EL FORMATO DEL FICHERO MVNW DE WINDOWS A LINUX, SINO FALLABA
RUN sed -i -e 's/\r$//' ./mvnw

#OTRA MANERA RUN ./mvnm dependency:go-offline
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target


COPY ./msvc-usuarios/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/msvc-usuarios/target/msvc-usuarios-0.0.1-SNAPSHOT.jar .

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]