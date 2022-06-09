package com.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tools.CORSFilter;

@SpringBootApplication
public class SpAppCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpAppCard.class,args);
	}
	

}
