FROM cimg/openjdk:11.0
VOLUME /tmp
WORKDIR /tmp
COPY target/*.jar /tmp/app.jar
ENTRYPOINT ["java","-jar","/tmp/app.jar"]