FROM java:8u111-jdk
WORKDIR /app
ADD target/springboot-init-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
ENV app=springboot-init
ENV TZ=Asia/Shanghai
ENTRYPOINT ["java", "-jar", "springboot-init-0.0.1-SNAPSHOT.jar"]
