package com.revature.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication // (scanBasePackages = "com.revature") //alternative to @ComponentScan
@ComponentScan("com.revature")
@EntityScan("com.revature.beans")
@EnableJpaRepositories("com.revature.repositories")
public class TutorMsStsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorMsStsApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE")
						.allowedHeaders("*").allowCredentials(false).maxAge(3600);
				;
			}
		};
	}
}
