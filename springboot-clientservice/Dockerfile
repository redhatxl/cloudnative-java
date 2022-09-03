FROM java:8u111-jdk
WORKDIR /app
ADD target/springboot-clientservice-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
ENV app=springbootclientservice
ENV TZ=Asia/Shanghai
ENTRYPOINT ["java", "-jar", "springboot-clientservice-0.0.1-SNAPSHOT.jar"]
