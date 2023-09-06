FROM openjdk:17

COPY target/examproject.jar exam-github.jar

ENTRYPOINT [ "java","-jar","exam-github.jar" ]