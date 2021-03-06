package org.interestTeam.model2.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import lombok.Data;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author dongshengzhang
 * @category 文档生成类
 */
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix="project")
@Data
public class Swagger2 {

	String name;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("org.interestTeam.model.controller"))
                .apis(RequestHandlerSelectors.any())
                //.paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))//取消掉默认的controller
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(this.name+"项目使用Swagger2构建RESTful APIs")
                .description("这是SWAGGER_2生成的接口文档")
                .termsOfServiceUrl("NO terms of service")
                .contact(new Contact("@author dongshengzhang", "", "emai@qq.com"))
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.1")
                .build();
    }

}
