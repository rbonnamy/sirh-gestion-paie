package dev.paie.ihm;

import dev.paie.exception.StockageException;

public abstract class OptionMenu implements Comparable<OptionMenu>{
	
	protected String libelle;


	public OptionMenu() {
		super();
	}
	
	public abstract boolean execute() throws StockageException;
	
	public int compareTo(OptionMenu optionMenu) {
		return optionMenu.getLibelle().compareTo(libelle);
	}
	
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
