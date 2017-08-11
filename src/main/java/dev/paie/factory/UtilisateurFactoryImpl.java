package dev.paie.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.Role;

@Service
public class UtilisateurFactoryImpl implements UtilisateurFactory {
	
	@Autowired PasswordEncoder passwordEncoder;
	
	/* (non-Javadoc)
	 * @see dev.paie.entite.UtilisateurFactory#getUtilisateur(java.lang.String, java.lang.String, dev.paie.entite.Utilisateur.Role)
	 */
	@Override
	public Utilisateur getUtilisateur(String nom, String password, Role role){
		String encryptedPassword = this.passwordEncoder.encode(password);
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNomUtilisateur(nom);
		utilisateur.setMotDePasse(encryptedPassword);
		utilisateur.setEstActif(true);
		utilisateur.setRole(role);
		
		return utilisateur;
	}
}
