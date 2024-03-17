
FROM maven:3.9.6 AS MAVEN_TOOL_CHAIN


COPY pom.xml /app/pom.xml
COPY /real-estate-modules  /app/real-estate-modules
COPY /real-estate-business /app/real-estate-business
COPY /real-estate-rest /app/real-estate-rest/




WORKDIR /app

RUN mvn -B -e -C org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline

RUN mvn clean install

RUN mvn -f /app/real-estate-business/pom.xml clean install

RUN mvn -f /app/real-estate-rest/pom.xml clean install



#FROM openjdk:17


RUN cp real-estate-rest/target/rest-0.0.1-SNAPSHOT-exec.jar .

#COPY /real-estate-rest/target/rest-0.0.1-SNAPSHOT-exec.jar .

ENTRYPOINT ["java","-jar","rest-0.0.1-SNAPSHOT-exec.jar"]