package dev.paie.service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

/**
 * Interface de service de calcul de rémunération
 * 
 * @author DIGINAMIC
 */
public interface CalculerRemunerationService {
	/**
	 * Calcule les différents éléments de rémunération en fonction des données
	 * du bulletin de salaire
	 * 
	 * @param bulletin
	 *            bulletin de salaire
	 * @return {@link ResultatCalculRemuneration}
	 */
	ResultatCalculRemuneration calculer(BulletinSalaire bulletin);
}
