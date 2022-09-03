# 一 背景
配置中心，使用K8s原上 configmap/secret资源替代原始 springcloudconfig服务。

# 二 接口

`/value`: 通过value获取configmap数据
`/valuesecret`: 通过value获取secret数据

`/properties`: 通过properties 获取configmap数据
`/propertiessecret`: 通过properties 获取secret数据


`/env`: 通过env 获取configmap数据
`/envsecret`: 通过env 获取secret数据


# 三 其他
## 3.1 功能简介
SpringCloud Kubernetes Config 组件主要提供以下几种功能：

实时监控 ConfigMap、Secret 配置变化从而更新服务配置。

定时轮询加载 ConfigMap、Secret 配置从而更新服务配置。
## 3.2 spring-cloud-starter-kubernetes-config
spring-cloud-starter-kubernetes-config是spring-cloud-starter-kubernetes下的一个库，作用是将kubernetes的configmap与SpringCloud Config结合起来。
spring-boot-actuator/ spring-boot-actuator-autoconfigure 两个包的引入，使得应用可以进行热更新，当configmap/secret发生变更的时候，可以不重启Pod或进程进行热变更配置。

```yaml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-actuator-autoconfigure</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>

```

# 四 目录结构

```shell
├── Dockerfile
├── HELP.md
├── README.md
├── deploy
│   ├── cm.yaml
│   ├── deploy.yaml
│   └── secret.yaml
├── mvnw
├── mvnw.cmd
├── pom.xml
├── springboot-config.iml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── xuel
│   │   │           ├── config
│   │   │           │   ├── SpringBootConfigProperties.java
│   │   │           │   └── SpringBootConfigPropertiesSecret.java
│   │   │           ├── controller
│   │   │           │   └── SpringBootConfigController.java
│   │   │           └── springbootconfig
│   │   │               └── SpringbootConfigApplication.java
│   │   └── resources
│   │       ├── bootstrap.yml
│   │       ├── static
│   │       └── templates

```


# 五 打包命令

```shell
# 制定镜像tag
IMG_TAG=img_v2
# clena/package, docker build / push
./mvnw clean package -D skipTests && docker build -t ccr.ccs.tencentyun.com/xxxxxxxxxxxxx/springbootconfig:${IMG_TAG} . && docker push ccr.ccs.tencentyun.com/xxxxxxxxxxxxx/springbootconfig:${IMG_TAG}
# 替换镜像
DEPLOY_FILE=deploy/deploy.yaml

sed -ie "s@$(grep -E "^[[:space:]]+image:" ${DEPLOY_FILE} | awk '{print $2}' |cut -d: -f 2|head -1)@${IMG_TAG}@g" deploy/deploy.yaml
# 应用更新
k apply -f deploy/.

k get po -A -w

k port-forward -n springconfig --address 0.0.0.0 svc/springbootconfig 8888:8080

```


# 六 参考链接
* https://github.com/kingschan1204/blog/issues/35