FROM adoptopenjdk/openjdk11:jdk-11.0.10_9-alpine
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} bs-book-service.jar
RUN sh -c 'touch /bs-book-service.jar'
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /bs-book-service.jar"]