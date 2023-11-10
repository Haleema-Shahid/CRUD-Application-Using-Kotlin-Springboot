FROM openjdk:17
ADD target/kotlin-springboot-assignment.jar kotlin-springboot-assignment.jar
ENTRYPOINT ["java","-jar","/kotlin-springboot-assignment.jar"]