package com.atguigu.spzx.manager;

import com.atguigu.spzx.common.log.annotation.EnableLogAspect;
import com.atguigu.spzx.manager.properties.MinioProperties;
import com.atguigu.spzx.manager.properties.UserAuthProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author llw
 */
@EnableAsync
@EnableLogAspect
@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = {"com.atguigu.spzx"})
@EnableConfigurationProperties(value = {UserAuthProperties.class, MinioProperties.class})
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
        System.out.println(" (♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ ");
    }
}
