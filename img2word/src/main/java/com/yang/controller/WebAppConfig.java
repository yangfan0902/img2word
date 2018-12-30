package com.yang.controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer  {
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/temp-rainy/**").addResourceLocations("file:C:/Users/fan/Desktop/");
    }

}
