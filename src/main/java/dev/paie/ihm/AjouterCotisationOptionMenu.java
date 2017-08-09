package dev.paie.ihm;

import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.exception.StockageException;
import dev.paie.repository.CotisationRepository;

/** Controller permettant de prendre en charge l'ajout d'une cotisation
 * @author DIGINAMIC
 */
@Controller
public class AjouterCotisationOptionMenu extends OptionMenu {
	
	/** cotisationRepository : CotisationRepository */
	private CotisationRepository cotisationRepository;
	
	/** scanner : Scanner */
	private Scanner scanner;

	/** Constructeur Autowired
	 * @param cotisationRepository permet de gérer la persistence des cotisations
	 * @param scanner permet de poser des questions à l'utilisateur
	 */
	@Autowired
	public AjouterCotisationOptionMenu(CotisationRepository cotisationRepository, Scanner scanner) {
		this.cotisationRepository = cotisationRepository;
		this.scanner = scanner;
	}

	@Override
	public String getLibelle() {
		return "Ajouter une cotisation";
	}

	/* Le @Transactional n'est pas nécessaire ici. Il est géré par le repository. 
	 * Si besoin de faire plusieurs opérations, faire une couche de services
	 * @see dev.paie.ihm.OptionMenu#execute()
	 */
	@Override
	public boolean execute() throws StockageException {
		
		System.out.println("Veuillez saisir un code:");
		String code = scanner.next();
		
		System.out.println("Veuillez saisir un libellé:");
		String libelle = scanner.next();

		System.out.println("Veuillez saisir le taux patronal:");
		String txPatronal = scanner.next();
		if (!NumberUtils.isCreatable(txPatronal)) {
			throw new StockageException("Le taux patronal de la nouvelle cotisation n'est pas un nombre.");
		}
		
		System.out.println("Veuillez saisir le taux salarial:");
		String txSalarial = scanner.next();
		if (!NumberUtils.isCreatable(txSalarial)) {
			throw new StockageException("Le taux salarial de la nouvelle cotisation n'est pas un nombre.");
		}	
		
		Cotisation cotisation = new Cotisation(code, libelle, new BigDecimal(txPatronal), new BigDecimal(txSalarial));
		cotisationRepository.save(cotisation);
		return false;
	}
}
