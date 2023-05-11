# define base docker image
FROM openjdk:17
LABEL maintainer="javaguides.net"
ADD target/custProject-0.0.1-SNAPSHOT.jar custProject.jar
ENTRYPOINT ["java","-jar", "custProject.jar"]