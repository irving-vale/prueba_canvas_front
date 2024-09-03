package com.joirv.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		        .allowedOrigins("https://main--cool-melomakarona-f5fccd.netlify.app/") // Cambia esto si tu frontend está en otro puerto o dominio
		        .allowedMethods("*")
		        .allowedHeaders("*");
	}
}
