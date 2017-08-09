package dev.paie.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/** Point d'entrée de la configuration de l'application:
 * - charge les controleurs stockés dans dev.paie.ihm
 * - charge la classe de configuration de la partie service {@link ServicesConfig}
 * @author DIGINAMIC
 */
@Configuration
@ComponentScan(basePackages={"dev.paie.ihm"})
@Import({ServicesConfig.class})
public class AppConfig {
	
	/** Créé un bean singleton de type Scanner
	 * @return Scanner
	 */
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
}
