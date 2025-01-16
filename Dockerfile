FROM openjdk:23
EXPOSE 8080
ADD build/libs /ecom-proj-0.0.1-SNAPSHOT.jar ecom-proj-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", ".jar", "/ecom-proj-0.0.1-SNAPSHOT.jar"]