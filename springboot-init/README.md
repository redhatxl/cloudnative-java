# 一 背景
服务注册，仅需为服务编写 service yaml 资源清单即可。
springboot-init 为服务提供者，对外提供 /services 用于获取 K8s 名称空间的名称，及返回相应 POD 的hostname。

# 二 接口

`/services`: 获取到对的service 列表，当前的时间，相应的 Pod 主机名称。


# 三 其他
## 3.1 服务注册
服务注册，不用额外在代码中编写服务注册代码，仅需为服务编写对应的service ， service 名称即为服务名称。

## 3.2 服务发现
通过引入 spring-cloud-starter-kubernetes-client-all 进行服务发现；

```yaml
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-kubernetes-client-all</artifactId>
<version>2.1.3</version>
</dependency>

```

# 四 目录结构

```shell
├── Dockerfile                                  // Dockerfile
├── HELP.md
├── README.md
├── deploy                                      // K8s 部署文件
│   └── deploy.yaml
├── mvnw
├── mvnw.cmd
├── pom.xml
├── springboot-init.iml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── xuel
│   │   │           └── springbootinit
│   │   │               ├── DiscoveryService.java             // 控制器
│   │   │               └── SpringbootInitApplication.java    // 启动类
│   │   └── resources
│   │       ├── application.yml                                     // 配置文件
│   │       ├── static
│   │       └── templates

```


# 五 打包命令

```shell
# 制定镜像tag
IMG_TAG=V5
# clena/package, docker build / push
./mvnw clean package && docker build -t ccr.ccs.tencentyun.com/xxxxxxxxxxxxx/springbootinit:${IMG_TAG} . && docker push ccr.ccs.tencentyun.com/xxxxxxxxxxxxx/springbootinit:${IMG_TAG}
```


# 六 其他

服务多副本通过deployment的replicase 确定，配置有 readinessProbe ，服务启动异常不回添加到后端endpoints中，服务消费者不后调用异常服务。