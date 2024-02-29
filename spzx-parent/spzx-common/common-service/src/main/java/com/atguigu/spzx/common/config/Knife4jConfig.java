package com.atguigu.spzx.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Tag： 用在controller类上，对controller进行说明
 * @Operation: 用在controller接口方法上对接口进行描述
 * @Parameters： 用在controller接口方法上对单个参数进行描述
 * @Schema： 用在实体类和实体类属性上，对实体类以及实体类属性进行描述
 */

@Configuration
public class Knife4jConfig {

    private final static String authTokenHeaderName = "token";  // 替换为实际用于身份验证的请求头名称

    @Bean
    public GroupedOpenApi adminApi() {      // 创建了一个api接口的分组
        return GroupedOpenApi.builder()
                .group("admin-api")         // 分组名称
                .pathsToMatch("/admin/**")  // 接口请求路径规则
                .addOperationCustomizer((operation, handlerMethod) -> {
//                    // 获取请求路径
//                    String requestMappingPath = "/admin" + handlerMethod.getMethod().getAnnotation(RequestMapping.class).value()[0];
//                    // 使用 antPath 匹配路径--排除登录接口和生成验证码接口
//                    if (new AntPathMatcher().match("/admin/system/index/login", requestMappingPath)
//                            || new AntPathMatcher().match("/admin/system/index/generateValidateCode", requestMappingPath)) {
//                        return operation;
//                    }
                    operation.addSecurityItem(new SecurityRequirement().addList(authTokenHeaderName));
                    return operation;
                })
                .build();
    }

    /***
     * @description 自定义接口信息
     */
    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("尚品甑选API接口文档")
                        .version("1.0")
                        .description("尚品甑选API接口文档")
                        .contact(new Contact().name("llw"))) // 设定作者
                .components(new Components()
                        .addSecuritySchemes(authTokenHeaderName, new SecurityScheme()
                                .type(SecurityScheme.Type.APIKEY)
                                .name(authTokenHeaderName)
                                .in(SecurityScheme.In.HEADER)))
                .addSecurityItem(new SecurityRequirement().addList(authTokenHeaderName));
    }

}
