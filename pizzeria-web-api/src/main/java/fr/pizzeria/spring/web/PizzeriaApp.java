package fr.pizzeria.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Application PizzeriaApp démarré via Spring Boot.
 */
@SpringBootApplication
@EnableJpaRepositories("fr.pizzeria.spring.web.repository")
@EntityScan("fr.pizzeria.model")
public class PizzeriaApp {

	/**
	 * Activation de CORS pour tous les domaines.
	 * 
	 * @return Configurateur Spring MVC.
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods(HttpMethod.PUT.name(),
						HttpMethod.DELETE.name(), HttpMethod.POST.name(), HttpMethod.GET.name());
			}
		};
	}

	/**
	 * Démarrage de l'application Web.
	 *
	 * @param args
	 *            argument du programme
	 */
	public static void main(String[] args) {
		SpringApplication.run(PizzeriaApp.class);
	}
}
