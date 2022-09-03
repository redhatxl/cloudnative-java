# 一 背景
服务注册，仅需为服务编写 service yaml 资源清单即可。
springboot-client 为使用 k8s service 进行服务发现 endpoints 列表，通过 ribbon 进行服务发起(客户端)进行负载均衡。

# 二 接口

`/clientsvc`: 获取 K8s 内部列表，即请求到的 POD hostname。


# 三 其他
## 3.1 服务注册
服务注册，不用额外在代码中编写服务注册代码，仅需为服务编写对应的service ， service 名称即为服务名称。

## 3.2 服务发现
通过引入 spring-cloud-starter-kubernetes-client-all 进行服务发现；
通过引入 spring-cloud-loadbalancer 进行客户端负载均衡；
通过引入 spring-cloud-starter-openfeign 进行客户端http 请求发起。

```yaml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
    <version>3.1.3</version>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-loadbalancer</artifactId>
    <version>3.1.3</version>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-kubernetes-client-all</artifactId>
    <version>2.1.3</version>
</dependency>
```

# 四 目录结构

```shell
├── Dockerfile                          // Dockerfile
├── HELP.md
├── README.md
├── deploy                              // Kubernetes 部署目录
│   └── deploy.yaml
├── mvnw
├── mvnw.cmd
├── pom.xml
├── springboot-client.iml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── xuel
│   │   │           ├── controller                                    // controller 
│   │   │           │   └── FeignDemoController.java
│   │   │           ├── feign 
│   │   │           │   └── ServiceDemoFeign.java               // 定义远程调用feign接口
│   │   │           ├── service
│   │   │           │   ├── FeignDemoService.java               // service 
│   │   │           │   └── impl
│   │   │           │       └── FeignDemoServiceImpl.java       // service 实现
│   │   │           └── springbootclient
│   │   │               └── SpringbootClientApplication.java          // 启动类
│   │   └── resources
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates

```


# 五 打包命令

```shell
# 制定镜像tag
IMG_TAG=V6
# clena/package, docker build / push
./mvnw clean package && docker build -t ccr.ccs.tencentyun.com/xxxxxxxxxx/springbootclient:${IMG_TAG} . && docker push ccr.ccs.tencentyun.com/xxxxxxxxxx/springbootclient:${IMG_TAG}
```