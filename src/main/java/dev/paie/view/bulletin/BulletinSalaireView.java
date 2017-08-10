package dev.paie.view.bulletin;

public class BulletinSalaireView {

	private String matricule;
	private Integer periodeId;
	private String primeExceptionnelle;
	
	/** Getter for matricule
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}
	/** Setter
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	/** Getter for periodeId
	 * @return the periodeId
	 */
	public Integer getPeriodeId() {
		return periodeId;
	}
	/** Setter
	 * @param periodeId the periodeId to set
	 */
	public void setPeriodeId(Integer periodeId) {
		this.periodeId = periodeId;
	}
	/** Getter for primeExceptionnelle
	 * @return the primeExceptionnelle
	 */
	public String getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	/** Setter
	 * @param primeExceptionnelle the primeExceptionnelle to set
	 */
	public void setPrimeExceptionnelle(String primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	
}
