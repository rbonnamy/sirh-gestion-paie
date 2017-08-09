package dev.paie.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.exception.StockageException;
import dev.paie.repository.CotisationRepository;

/** Controller permettant de prendre en charge la suppression d'une cotisation
 * @author DIGINAMIC
 */
@Controller
public class SupprimerCotisationOptionMenu extends OptionMenu {

	/** cotisationRepository : CotisationRepository */
	private CotisationRepository cotisationRepository;
	
	/** scanner : Scanner */
	private Scanner scanner;
	
	/** Constructeur Autowired
	 * @param cotisationRepository permet de gérer la persistence des cotisations
	 * @param scanner permet de poser des questions à l'utilisateur
	 */
	public SupprimerCotisationOptionMenu(CotisationRepository cotisationRepository, Scanner scanner) {
		this.cotisationRepository = cotisationRepository;
		this.scanner = scanner;
	}

	@Override
	public String getLibelle() {
		return "Supprimer une cotisation";
	}

	/* Le @Transactional n'est pas nécessaire ici. Il est géré par le repository. 
	 * Si besoin de faire plusieurs opérations, faire une couche de services
	 * @see dev.paie.ihm.OptionMenu#execute()
	 */
	@Override
	public boolean execute() throws StockageException {
		
		System.out.println("Veuillez choisir la cotisation à supprimer:");
		String codeASupprimer = scanner.next();

		Cotisation cotisation = cotisationRepository.findByCodeIgnoreCase(codeASupprimer);
		if (cotisation==null){
			throw new StockageException("Le code de la cotisation saisie n'existe pas.");
		}
		cotisationRepository.delete(cotisation);
		
		return true;
	}
}
