FROM java:8u111-jdk
WORKDIR /app
ADD target/springboot-config-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
ENV app=springbootclient
ENV TZ=Asia/Shanghai
ENTRYPOINT ["java", "-jar", "springboot-config-0.0.1-SNAPSHOT.jar"]
