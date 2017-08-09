package dev.paie.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;

@Controller
public class ListerCotisationsOptionMenu extends OptionMenu {

	private CotisationRepository cotisationRepository;

	/** Constructeur
	 */
	@Autowired
	public ListerCotisationsOptionMenu(CotisationRepository cotisationRepository) {
		this.cotisationRepository = cotisationRepository;
	}

	@Override
	public String getLibelle() {
		return "Lister les cotisations";
	}

	@Override
	public boolean execute() {
		
		List<Cotisation> cotisations = cotisationRepository.findAll();
		cotisations.stream().forEach(c -> System.out.println("Code: "+ c.getCode()+" - Libellé: "+c.getLibelle()+" - Tx patronal: "+ c.getTauxPatronal() + " - Tx salarial: "+ c.getTauxSalarial()));
		return true;
	}
}
