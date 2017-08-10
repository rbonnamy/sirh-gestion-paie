package dev.paie.view.bulletin;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.ResultatCalculRemuneration;

public class BulletinSalaireViewForVisualisation {

	private String periode;
	
	private ResultatCalculRemuneration resultat;
	
	private RemunerationEmploye remunerationEmploye;

	/** Getter for periode
	 * @return the periode
	 */
	public String getPeriode() {
		return periode;
	}

	/** Setter
	 * @param periode the periode to set
	 */
	public void setPeriode(String periode) {
		this.periode = periode;
	}

	/** Getter for remunerationEmploye
	 * @return the remunerationEmploye
	 */
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}

	/** Setter
	 * @param remunerationEmploye the remunerationEmploye to set
	 */
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}

	/** Getter for resultat
	 * @return the resultat
	 */
	public ResultatCalculRemuneration getResultat() {
		return resultat;
	}

	/** Setter
	 * @param resultat the resultat to set
	 */
	public void setResultat(ResultatCalculRemuneration resultat) {
		this.resultat = resultat;
	}
}
