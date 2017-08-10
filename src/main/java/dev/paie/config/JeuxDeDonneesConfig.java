package dev.paie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/** Charge des beans contenus dans un fichier xml
 * @author DIGINAMIC
 */
@Configuration
@ImportResource("classpath:jdd-config.xml")
public class JeuxDeDonneesConfig {
	
}