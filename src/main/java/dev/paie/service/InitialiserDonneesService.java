package dev.paie.service;

public interface InitialiserDonneesService {
	/**
	 * Méthode d'initialisation par défaut
	 */
	void initialiser();
	
	/**
	 * Méthode d'initialisation avec l'entityManager JPA
	 */
	void initialiserEntityManager();
}
