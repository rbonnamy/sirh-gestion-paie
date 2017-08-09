package dev.paie.ihm;

import dev.paie.exception.StockageException;

/** Représente une option de menu de l'application console
 * @author DIGINAMIC
 */
public abstract class OptionMenu {
	
	/** libelle : String */
	protected String libelle;

	/**
	 * Consrructeur
	 */
	public OptionMenu() {
		super();
	}
	
	/** Exécution du cas d'utilisation de l'option de menu
	 * @return boolean
	 * @throws StockageException en cas d'erreur de persistence
	 */
	public abstract boolean execute() throws StockageException;

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

}
