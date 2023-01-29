ARG MSVC_NAME=msvc-usuarios

FROM openjdk:17-jdk-alpine as builder
ARG MSVC_NAME
WORKDIR /app/$MSVC_NAME

#COPY ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar /app
COPY ./pom.xml /app
COPY ./$MSVC_NAME/.mvn ./.mvn
COPY ./$MSVC_NAME/mvnw .
COPY ./$MSVC_NAME/pom.xml .

#ESTE COMANDO SOLO HA SIDO NECESARIO PARA CONVERTIR EL FORMATO DEL FICHERO MVNW DE WINDOWS A LINUX, SINO FALLABA
RUN sed -i -e 's/\r$//' ./mvnw

#OTRA MANERA RUN ./mvnm dependency:go-offline
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target


COPY ./$MSVC_NAME/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine
ARG MSVC_NAME
WORKDIR /app

RUN mkdir ./logs

ARG TARGET_FOLDER=/app/$MSVC_NAME/target
COPY --from=builder $TARGET_FOLDER/msvc-usuarios-0.0.1-SNAPSHOT.jar .
ARG PORT_APP=8001
ENV PORT $PORT_APP
EXPOSE $PORT

#No permite ingresar un comando de inicio, como la ejecución de una consola, cmd si lo permite
#ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]
CMD ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]

##docker network create spring
##docker build -t usuarios -f .\msvc-usuarios\Dockerfile --build-arg PORT_APP=8001
##docker build -t cursos . -f .\msvc-cursos\Dockerfile
##docker pull mysql:8
##docker run -d -p 3307:3306 --name mysql8 --network spring -e MYSQL_ROOT_PASSWORD=sasa -e MYSQL_DATABASE=msvc_usuarios -v data-mysql:/var/lib/mysql --restart=always mysql:8
##docker run -p 5532:5432 --name postgres14 --network spring -e POSTGRES_PASSWORD=sasa -e POSTGRES_DB=msvc_cursos -d -v data-postgres:/var/lib/postgresql/data --restart=always postgres:14-alpine
##docker run -d -p 8002:8002 --name msvc-cursos --rm --network spring cursos
##docker run -d -p 8001:8001 --env PORT=8001 --name msvc-usuarios --rm --network spring usuarios
##docker run -d -p 8001:8001 --env-file .\msvc-usuarios\.env --rm --name msvc-usuarios --network spring usuarios
