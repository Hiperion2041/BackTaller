package com.nivelacion.taller;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nivelacion.taller.enums.Role;
import com.nivelacion.taller.models.Usuario;
import com.nivelacion.taller.services.UsuarioService;

@SpringBootApplication
public class TallerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}

	@Bean     
	public WebMvcConfigurer corsConfigurer() {         
		return new WebMvcConfigurer() {             
			@Override             
			public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
				                 // we can provide other routes, further than the "/".                 
								 registry.addMapping("/")                         
								 .allowedOrigins("http://localhost:4200")                         
								 .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")                     
								 .allowedHeaders("Authorization", "Content-Type", "X-Requested-With")            
								 .allowCredentials(true);             }         };  

}
}
