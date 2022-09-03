# 一 背景
服务注册，仅需为服务编写 service yaml 资源清单即可。
springboot-clientservice 为使用 k8s service 进行发现服务。

# 二 接口

`/getsvc`: 获取 K8s 内部列表，即请求到的 POD hostname。


# 三 其他
## 3.1 服务注册
服务注册，不用额外在代码中编写服务注册代码，仅需为服务编写对应的service ， service 名称即为服务名称。

## 3.2 服务发现
引入 spring-cloud-starter-openfeign 进行客户端http请求发起；
引入 spring-cloud-starter-loadbalancer 进行负载均衡（实际针对service发起调用不用负载均衡）；

```yaml
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-openfeign</artifactId>
<version>3.1.3</version>
</dependency>

<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-loadbalancer</artifactId>
<version>3.1.3</version>
</dependency>

```

# 四 目录结构

```shell
.
├── Dockerfile
├── HELP.md
├── README.md
├── deploy
│   ├── deploy.yaml
├── mvnw
├── mvnw.cmd
├── pom.xml
├── springboot-clientservice.iml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── xuel
│   │   │           ├── controller
│   │   │           │   └── SpringBootClientServiceController.java
│   │   │           ├── feign
│   │   │           │   └── FeignService.java
│   │   │           ├── service
│   │   │           │   ├── SpringBootClientService.java
│   │   │           │   └── impl
│   │   │           │       └── SpringBootClientServiceImpl.java
│   │   │           └── springbootclientservice
│   │   │               └── SpringbootClientserviceApplication.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates


```


# 五 打包命令

```shell

# 制定镜像tag
IMG_TAG=img_v6
# clena/package, docker build / push
./mvnw clean package -D skipTests && docker build -t ccr.ccs.tencentyun.com/xxxxxxxxxxxxx/springbootclientservice:${IMG_TAG} . && docker push ccr.ccs.tencentyun.com/xxxxxxxxxxxxx/springbootclientservice:${IMG_TAG}
# 替换镜像
DEPLOY_FILE=deploy/deploy.yaml

sed -ie "s@$(grep -E "^[[:space:]]+image:" ${DEPLOY_FILE} | awk '{print $2}' |cut -d: -f 2|head -1)@${IMG_TAG}@g" deploy/deploy.yaml
# 应用更新
k apply -f deploy/.

k get po -A -w

k port-forward -n spring --address 0.0.0.0 svc/springbootclientservice 8888:8080

```
