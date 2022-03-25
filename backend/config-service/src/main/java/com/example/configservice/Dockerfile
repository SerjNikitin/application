FROM java:latest

WORKDIR /app

COPY ../../../../../../.mvn .mvn
COPY ../../../../../../mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY ../../../../.. ./src

CMD ["./mvnw", "spring-boot:run"]


#FROM java:latest
#ADD ConfigServiceApplication /config-service/
#WORKDIR /config-service/


#FROM openjdk:latest
##RUN mkdir -p /application/backend/config-service/
#WORKDIR /config-service
##COPY config-service-0.0.1-SNAPSHOT.jar ./app.jar
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN mkdir -p /config-service
##RUN ./mvnw dependency:go-offline
#COPY src ./src
#CMD ["./mvnw", "spring-boot:run"]


#COPY . /config-service/
#CMD java $JAVA_OPTIONS -jar app.jar
#CMD ["java", "ConfigServiceApplication"]

#ADD config-service-0.0.1-SNAPSHOT.jar config-service.jar


#FROM maslick/minimalka:jdk11
#WORKDIR /app
#EXPOSE 8080
#COPY config-service-0.0.1-SNAPSHOT.jar ./app.jar
#CMD java $JAVA_OPTIONS -jar app.jar
