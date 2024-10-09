FROM amazoncorretto:21.0.4-alpine
VOLUME /tmp
EXPOSE 10000
ARG JAR_FILE=target/enrollments-1.0.0.jar
ADD ${JAR_FILE} enrollments.jar
LABEL name="enrollments"
LABEL authors="Angel Hincho"
LABEL mainteiner="ahincho"
COPY target/enrollments-1.0.0.jar enrollments.jar
ENTRYPOINT ["java","-jar","/enrollments.jar"]