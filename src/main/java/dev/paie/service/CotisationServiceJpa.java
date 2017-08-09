package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Service
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext 
	private EntityManager em;

	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
	}

	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {
		Query query = em.createQuery("FROM Cotisation c WHERE c.code=:code");
		query.setParameter("code", cotisation.getCode());
		
		List<Cotisation> oldCotisations = query.getResultList();
		if (!oldCotisations.isEmpty()){
			Cotisation oldCotisation = oldCotisations.get(0);
			oldCotisation.setCode(cotisation.getCode());
			oldCotisation.setLibelle(cotisation.getLibelle());
			oldCotisation.setTauxPatronal(cotisation.getTauxPatronal());
			oldCotisation.setTauxSalarial(cotisation.getTauxSalarial());
			em.merge(oldCotisation);
			em.flush();
		}
	}

	@Override
	public List<Cotisation> lister() {
		Query query = em.createQuery("FROM Cotisation");
	    return (List<Cotisation>) query.getResultList();
	}

}
