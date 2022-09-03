# 一 背景
springboot gateway serviceprovider 作为gateway后端API服务

# 二 服务功能
提供gateway后端服务

# 三 打包方式

```shell

# 制定镜像tag
IMG_TAG=img_v4
# clena/package, docker build / push
./mvnw clean package -D skipTests && docker build -t ccr.ccs.tencentyun.com/xxxxxxxxxxxxx/springbootgatewayserviceprovider:${IMG_TAG} . && docker push ccr.ccs.tencentyun.com/xxxxxxxxxxxxx/springbootgatewayserviceprovider:${IMG_TAG}
# 替换镜像
DEPLOY_FILE=deploy/deploy.yaml

sed -ie "s@$(grep -E "^[[:space:]]+image:" ${DEPLOY_FILE} | awk '{print $2}' |cut -d: -f 2|head -1)@${IMG_TAG}@g" deploy/deploy.yaml
# 应用更新
k apply -f deploy/.

k get po -A -w

k port-forward -n springgateway --address 0.0.0.0 svc/springbootgatewayserviceprovider 8888:8080

```
