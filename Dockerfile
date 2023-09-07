FROM openjdk:17


COPY target/examproject.war examproject.war

ENTRYPOINT [ "java","-jar","examproject.war" ]