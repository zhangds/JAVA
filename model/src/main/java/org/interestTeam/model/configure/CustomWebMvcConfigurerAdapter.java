package org.interestTeam.model.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author dongshengzhang
 * 标注此文件为一个配置项，spring boot才会扫描到该配置。该注解类似于之前使用xml进行配置
 */
@Configuration
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
	
	@Bean
	WebInterceptor  webInterceptor(){
        return new WebInterceptor();
    }
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webInterceptor()).excludePathPatterns("/swagger**/**").addPathPatterns("/**");  //对来自/** 这个链接来的请求进行拦截
        super.addInterceptors(registry);
    }
	
}