package dev.paie.factory;

import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.Role;

public interface UtilisateurFactory {

	Utilisateur getUtilisateur(String nom, String password, Role role);

}