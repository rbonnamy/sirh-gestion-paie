package dev.paie.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import dev.paie.exception.StockageException;

@Controller
public class Menu {
	
	/** scanner : Scanner */
	private Scanner scanner;
	
	private static int counter = 1;
	Map<Integer, OptionMenu> optionsMenu = new HashMap<>();
	
	@Autowired
	public Menu(ApplicationContext context, Scanner scanner){
		
		this.scanner = scanner;
		
		Map<String, OptionMenu> beansOfType = context.getBeansOfType(OptionMenu.class);
		beansOfType.forEach( (key, option) -> optionsMenu.put(counter++, option));
	}
	
	protected void afficher(){
		System.out.println("***** Cotisations Administration *****");
		optionsMenu.forEach((key, option)-> System.out.println(key+". "+option.getLibelle()));		
		System.out.println("99. Sortie.");
	}


	public void manage() {
		int choixMenu = 0;
		while (choixMenu != 99) {

			// Affichage du menu
			afficher();

			// Poser une question
			choixMenu = scanner.nextInt();

			// Analyse de la réponse à la question
			try {
				optionsMenu.get(choixMenu).execute();
			} catch (StockageException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
