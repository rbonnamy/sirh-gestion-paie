package dev.paie.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.exception.StockageException;
import dev.paie.repository.CotisationRepository;

@Controller
public class SupprimerCotisationOptionMenu extends OptionMenu {

	@Autowired
	private CotisationRepository cotisationRepository;
	
	@Autowired
	private Scanner scanner;
	
	public SupprimerCotisationOptionMenu() {
	}

	@Override
	public String getLibelle() {
		return "Supprimer une cotisation";
	}

	@Override
	// Le transactional est fait par le repository. Si besoin, faire une couche de services
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
