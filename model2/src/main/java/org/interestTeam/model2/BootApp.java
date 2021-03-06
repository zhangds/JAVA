/**
 * 
 */
package org.interestTeam.model2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author zds
 *
 */
@EnableAutoConfiguration
//@EnableScheduling
@EnableAsync
@EnableTransactionManagement
@EnableSwagger2
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = { "org.interestTeam.model2.*" })
@Slf4j
public class BootApp {
	public static void main(String[] args) {
		log.info("程序开始启动!...");
		SpringApplication.run(BootApp.class, args);
		log.info("程序启动完成!...");
	}
	
	@Bean
	public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            public void customize(ConfigurableWebServerFactory factory) {
                factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
                factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error/500"));
            }
        };
    }
}
