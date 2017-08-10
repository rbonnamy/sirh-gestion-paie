package dev.paie.view.bulletin;

public class BulletinSalaireViewForList {

	private Integer id;
	private String dateCreation;
	private String periode;
	private String matricule;
	private String salaireBrut;
	private String netImposable;
	private String netAPayer;
	
	/** Getter for dateCreation
	 * @return the dateCreation
	 */
	public String getDateCreation() {
		return dateCreation;
	}
	/** Setter
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	/** Getter for periode
	 * @return the periode
	 */
	public String getPeriode() {
		return periode;
	}
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
	/** Getter for salaireBrut
	 * @return the salaireBrut
	 */
	public String getSalaireBrut() {
		return salaireBrut;
	}
	/** Setter
	 * @param salaireBrut the salaireBrut to set
	 */
	public void setSalaireBrut(String salaireBrut) {
		this.salaireBrut = salaireBrut;
	}
	/** Getter for netImposable
	 * @return the netImposable
	 */
	public String getNetImposable() {
		return netImposable;
	}
	/** Setter
	 * @param netImposable the netImposable to set
	 */
	public void setNetImposable(String netImposable) {
		this.netImposable = netImposable;
	}
	/** Getter for netAPayer
	 * @return the netAPayer
	 */
	public String getNetAPayer() {
		return netAPayer;
	}
	/** Setter
	 * @param netAPayer the netAPayer to set
	 */
	public void setNetAPayer(String netAPayer) {
		this.netAPayer = netAPayer;
	}
	/** Setter
	 * @param periode the periode to set
	 */
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	/** Getter for id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/** Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
}
