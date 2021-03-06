
FROM openjdk:8
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ADD /target/employee-time-tracker-0.0.1-SNAPSHOT.jar /tmp/employee-time-tracker.jar
EXPOSE 8181

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar employee-time-tracker.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar employee-time-tracker.jar
