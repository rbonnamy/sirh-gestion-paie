package dev.paie.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UTILISATEURS")
public class Utilisateur {
	
	public enum Role {
		ROLE_ADMINISTRATEUR, ROLE_UTILISATEUR
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NOM")
	private String nomUtilisateur;
	
	@Column(name="PASSWORD")
	private String motDePasse;
	
	@Column(name="EST_ACTIF")
	private Boolean estActif;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ROLE")
	private Role role;

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

	/** Getter for nomUtilisateur
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	/** Setter
	 * @param nomUtilisateur the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	/** Getter for motDePasse
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/** Setter
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/** Getter for estActif
	 * @return the estActif
	 */
	public Boolean getEstActif() {
		return estActif;
	}

	/** Setter
	 * @param estActif the estActif to set
	 */
	public void setEstActif(Boolean estActif) {
		this.estActif = estActif;
	}

	/** Getter for role
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/** Setter
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}