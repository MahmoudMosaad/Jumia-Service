FROM openjdk:8
ADD target/jumia-service.jar jumia-service.jar
ADD ./sample.db sample.db
EXPOSE 8080
ENTRYPOINT ["java","-jar","jumia-service.jar"]