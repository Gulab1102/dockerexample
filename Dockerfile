FROM openjdk:17

COPY target/exam-github.jar exam-github.jar

ENTRYPOINT [ "java","-jar","exam-github.jar" ]