package com.jpop.zuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulGatewayApplication {

		public static void main(String[] args) {
			SpringApplication.run(ZuulGatewayApplication.class, args);
		}
		
		@Bean
		public WebMvcConfigurer corsConfigurer() {
		    return new WebMvcConfigurer() {
		        public void addCorsMappings(CorsRegistry registry) {
		            registry.addMapping("/**")
		                    .allowedOrigins("http://localhost:4200")
		                    .allowedMethods("GET", "POST","PUT","DELETE");
		        }
		    };
		}
}
