/**
 * ClassName: SwaggerConfig <br/>
 * Description: <br/>
 * date: 2020/11/24 22:12<br/>
 *
 * @author lz<br />
 */
package com.taizhou.taizhou_back.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * 1 引入依赖
 * 2 配置配置类@EnableSwagger2
 */

@Configuration //配置类
@EnableSwagger2// 开启Swagger2的自动配置
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean //配置docket以配置Swagger具体参数
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("group1")
                .apiInfo(apiInfo())
                //.enable(false) //配置是否启用Swagger，如果是false，在浏览器将无法访问
                .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.bgs.springbootswagger.controller"))
                // 配置如何通过path过滤,即这里只扫描请求以/user开头的接口
                //.paths(PathSelectors.ant("/user/**"))
                .build();
    }


    //配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("lz", "https://www.baidu.com", "931606620@qq.com");
        return new ApiInfo(
                "接口文档", // 标题
                "学习演示如何配置Swagger", // 描述
                "v1.0", // 版本
                "https://www.baidu.com", // 组织链接
                contact, // 联系人信息
                "XXX", // 许可
                "XXX", // 许可连接
                new ArrayList<>()// 扩展
        );
        /*Contact contact = new Contact("联系人名字", "http://xxx.xxx.com/联系人访问链接", "联系人邮箱");
        return new ApiInfo(
                "Swagger学习", // 标题
                "学习演示如何配置Swagger", // 描述
                "v1.0", // 版本
                "http://terms.service.url/组织链接", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );*/
    }

    @Bean //配置docket以配置Swagger具体参数
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group2");
    }

    @Bean //配置docket以配置Swagger具体参数
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
    }

}