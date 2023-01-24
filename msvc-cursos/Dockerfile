FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/msvc-cursos

#COPY ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar /app
COPY ./pom.xml /app
COPY ./msvc-cursos/.mvn ./.mvn
COPY ./msvc-cursos/mvnw .
COPY ./msvc-cursos/pom.xml .

#ESTE COMANDO SOLO HA SIDO NECESARIO PARA CONVERTIR EL FORMATO DEL FICHERO MVNW DE WINDOWS A LINUX, SINO FALLABA
RUN sed -i -e 's/\r$//' ./mvnw

#OTRA MANERA RUN ./mvnm dependency:go-offline
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target

COPY ./msvc-cursos/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

RUN mkdir ./logs

COPY --from=builder /app/msvc-cursos/target/msvc-cursos-0.0.1-SNAPSHOT.jar .

EXPOSE 8002

#No permite ingresar un comando de inicio, como la ejecución de una consola, cmd si lo permite
#ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]
CMD ["java", "-jar", "msvc-cursos-0.0.1-SNAPSHOT.jar"]