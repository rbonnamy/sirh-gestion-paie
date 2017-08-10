package dev.paie.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/** Charge des beans contenus dans un fichier xml
 * @author DIGINAMIC
 */
@Configuration
@ImportResource("classpath:init-data-web.xml")
public class InitDataWebConfig {

}