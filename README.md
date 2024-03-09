# shangpin-e-commerce-platform
商品甄选-电子商务平台项目，包含后台管理系统和前台用户系统，前后端分离开发模式，基于SpringBoot+SpringCloud微服务架构。



```
spzx-parent： 尚品甄选项目的父工程，进行项目依赖的统一管理，打包方式为pom

​	spzx-common:  尚品甄选项目公共模块的管理模块

​		common-util:    工具类模块

​		common-service：公共服务模块

​	spzx-model:  尚品甄选项目实体类模块

​	spzx-manager： 尚品甄选项目后台管理系统的后端服务

​	spzx-server-gateway： 尚品甄选项目的网关

​	spzx-service： 尚品甄选微服务模块的父工程

​		service-product：商品微服务模块

​		service-user：用户微服务模块

​		service-order：订单微服务模块

​	spzx-service-client： 尚品甄选微服务模块远程调用接口的父工程

​		service-product-client：商品微服务远程调用接口模块

​		service-user-client：用户微服务远程调用接口模块
```



```shell
docker pull mysql:8.0.30

docker run -d --name mysql -p 30036:3306 -v mysql_data:/var/lib/mysql -v mysql_conf:/etc/mysql -v /etc/localtime:/etc/localtime --restart=always --privileged=true -e MYSQL_ROOT_PASSWORD=1234 mysql:8.0.30

## mysql设置时间
# 查看当前时间
SELECT now();
# 查看时区信息
show variables like "%time_zone%";
# 修改mysql全局时区为北京时间
set global time_zone = '+8:00';
# 修改当前会话时区
set time_zone = '+8:00';
# 立即生效
flush privileges;
```



```shell
docker pull redis:7.0.10

cd /var/snap/docker/common/var-lib-docker/volumes/redis-config/_data
vim redis.conf
    #开启持久化
    appendonly yes
    port 6379
    # requirepass 1234
    bind 0.0.0.0
    # 关闭保护模式
    protected-mode no

docker run -d -p 6379:6379 --restart=always -v redis-config:/etc/redis/config -v redis-data:/data --name redis redis redis-server /etc/redis/config/redis.conf

systemctl status firewalld
systemctl restart firewalld.service
firewall-cmd --zone=public --add-port=6379/tcp --permanent
service redis restart
```



```shell
docker pull quay.io/minio/minio

docker run    -p 9001:9000    -p 9090:9090    --name minio    -v ~/minio/data:/data    -e "MINIO_ROOT_USER=admin"    -e "MINIO_ROOT_PASSWORD=admin123456"    -d    quay.io/minio/minio server /data --console-address ":9090"
```



```shell
docker pull nginx:latest

docker run -d -p 80:80 --name nginx-spzx -v nginx_html:/usr/share/nginx/html -v nginx_conf:/etc/nginx/ -v nginx_logs:/var/log/nginx  nginx
```



```
docker pull nacos/nacos-server:v2.2.2

docker run --name nacos -e MODE=standalone -p 8848:8848 -p 9848:9848 -d nacos/nacos-server:v2.2.2
```

