package dev.paie.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import dev.paie.exception.StockageException;

/** Représente le menu de l'application console
 * @author DIGINAMIC
 */
@Controller
public class Menu {
	
	/** scanner : Scanner */
	private Scanner scanner;
	
	/** Compteur des options de menu */
	private static int counter = 1;
	
	/** optionsMenu : contient toutes les options de menu */
	Map<Integer, OptionMenu> optionsMenu = new HashMap<>();
	
	@Autowired
	public Menu(ApplicationContext context, Scanner scanner){
		
		this.scanner = scanner;
		
		// On récupère tous les beans du type OptionMenu.class et on les injecte dans la map optionsMenu
		Map<String, OptionMenu> beansOfType = context.getBeansOfType(OptionMenu.class);
		beansOfType.forEach( (key, option) -> optionsMenu.put(counter++, option));
	}
	
	/**
	 * Affichage du menu
	 */
	protected void afficher(){
		System.out.println("***** Cotisations Administration *****");
		optionsMenu.forEach((key, option)-> System.out.println(key+". "+option.getLibelle()));		
		System.out.println("99. Sortie.");
	}


	/**
	 * Point d'entrée de la boucle de traitement du menu
	 */
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
