package dev.paie;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.paie.config.AppConfig;
import dev.paie.ihm.Menu;

public class ApplicationConsoleApp {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)){

			Menu menu  = context.getBean(Menu.class);
			menu.manage();
			
		}

	}

}
