package dev.paie;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.paie.config.AppConfig;
import dev.paie.ihm.Menu;

/** Application de gestion des cotisations
 * @author DIGINAMIC
 */
public class ApplicationConsoleApp {

	/** Point d'entrée
	 * @param args arguments du programme
	 */
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)){

			Menu menu  = context.getBean(Menu.class);
			menu.manage();
			
		}

	}

}
