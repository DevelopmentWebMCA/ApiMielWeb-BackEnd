package mca.apimiel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApimielApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApimielApplication.class, args);
	}

/*
	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				Definicion de cors para peticiones por parte de Vue Js
				registry.addMapping("/apimiel/web/**").
						allowedOrigins("http://localhost:9091/")
						.allowedMethods("*").allowedHeaders("*");

				Definición de cors para peticiones por parte de la app móvil
				registry.addMapping("/apimiel/movil/**").
						allowedOrigins("http://localhost") //Dirección de la app móvil
						.allowedMethods("*").allowedHeaders("*");


			}
		};
	}*/
}
