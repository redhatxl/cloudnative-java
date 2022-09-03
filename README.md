# 一 文章链接
SpringCloud Kubernetes 系列文章

## 1.1 服务注册发现
[云原生架构之服务发现与注册-总述](https://juejin.cn/post/7138963377896587301)


[云原生架构之SpringBoot+K8s service服务注册发现方案(东西流量) ](https://juejin.cn/post/7138975184114941965)

[云原生架构之SpringCloudKubernetes 服务注册发现方案(东西流量) ](https://juejin.cn/post/7138976400794943501)

[云原生架构之Springboot Gateway+K8s 服务注册发现方案(南北流量)](https://juejin.cn/post/7138977379229106190)



## 1.2 配置中心

[云原生架构之配置中心-总述](https://juejin.cn/post/7138979347817299975)

[云原生架构之Spring Cloud+Kubernetes配置中心方案](https://juejin.cn/post/7138981045130493966)


# 二 项目对应
## 2.1 服务注册发现(东西流量)
```shell

springboot-init:springboot-init 为服务提供者，对外提供 /services 用于获取 K8s 名称空间的名称，及返回相应 POD 的hostname。

springboot-client:springboot-client 为使用 k8s service 进行服务发现 endpoints 列表，通过 ribbon 进行服务发起(客户端)进行负载均衡。

springboot-clientservice:springboot-clientservice 为使用 k8s service 进行发现服务。

```

## 2.2 服务注册发现(南北流量)

```shell
springboot-gateway:springboot gateway 使用k8s作服务注册发现

springboot-gateway-serviceprovider:springboot gateway serviceprovider 作为gateway后端API服务

```

## 2.3 配置中心
```shell

springboot-config:配置中心，使用K8s原上 configmap/secret资源替代原始 springcloudconfig服务。

```