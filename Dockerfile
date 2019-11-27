FROM openjdk:13-slim
COPY build/libs/micronaut-test-*-all.jar app.jar
EXPOSE 8081
CMD java -XX:+UseContainerSupport -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar app.jar