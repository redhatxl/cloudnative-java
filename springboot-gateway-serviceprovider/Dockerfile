FROM java:8u111-jdk
WORKDIR /app
ADD target/springboot-gateway-serviceprovider-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
ENV app=springbootclientservice
ENV TZ=Asia/Shanghai
ENTRYPOINT ["java", "-jar", "springboot-gateway-serviceprovider-0.0.1-SNAPSHOT.jar"]
