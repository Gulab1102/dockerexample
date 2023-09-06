FROM openjdk:17

COPY target/examproject.jar examproject.jar

ENTRYPOINT [ "java","-jar","examproject.jar" ]