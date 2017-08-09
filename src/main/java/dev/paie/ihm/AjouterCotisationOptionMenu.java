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

@Controller
public class AjouterCotisationOptionMenu extends OptionMenu {
	
	private CotisationRepository cotisationRepository;
	
	private Scanner scanner;

	@Autowired
	public AjouterCotisationOptionMenu(CotisationRepository cotisationRepository, Scanner scanner) {
		this.cotisationRepository = cotisationRepository;
		this.scanner = scanner;
	}

	@Override
	public String getLibelle() {
		return "Ajouter une cotisation";
	}

	@Override
	// Le transactional est fait par le repository. Si besoin, faire une couche de services
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
