package com.atguigu.spzx.manager.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix="spzx.minio") //读取节点
public class MinioProperties {

    private String endpointUrl; // minio的url
    private String accessKey; // 账号
    private String secreKey; // 密码
    private String bucketName; // 桶名称

}
