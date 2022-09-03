# 一 背景
springboot gateway 使用k8s作服务注册发现

# 二 服务功能
gateway 提供转发功能

# 三 打包方式

```shell

# 制定镜像tag
IMG_TAG=img_v5
# clena/package, docker build / push
./mvnw clean package -D skipTests && docker build -t ccr.ccs.tencentyun.com/xxxxxxxxxxxxx/springbootgateway:${IMG_TAG} . && docker push ccr.ccs.tencentyun.com/xxxxxxxxxxxxx/springbootgateway:${IMG_TAG}
# 替换镜像
DEPLOY_FILE=deploy/deploy.yaml

sed -ie "s@$(grep -E "^[[:space:]]+image:" ${DEPLOY_FILE} | awk '{print $2}' |cut -d: -f 2|head -1)@${IMG_TAG}@g" deploy/deploy.yaml
# 应用更新
k apply -f deploy/.

k get po -A -w

k port-forward -n springgateway --address 0.0.0.0 svc/springbootgateway 9999:8080

```

# 四 服务访问

```shell
http://localhost:9999/springbootgatewayserviceprovider/api
```

# 五 tapd链接
* https://www.tapd.cn/59887852/markdown_wikis/show/#1159887852001001645