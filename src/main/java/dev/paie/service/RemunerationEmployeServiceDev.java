package dev.paie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.beanview.RemunerationEmployeView;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Service
@Transactional
public class RemunerationEmployeServiceDev implements RemunerationEmployeService {

	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private ProfilRemunerationRepository profilRepository;
	
	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;
	
	public void creerEmploye(RemunerationEmployeView view){
		
		Entreprise entreprise = entrepriseRepository.findOne(view.getEntrepriseId());
		Grade grade = gradeRepository.findOne(view.getGradeId());
		ProfilRemuneration profil = profilRepository.findOne(view.getProfilId());
		
		RemunerationEmploye employe = new RemunerationEmploye();
		employe.setMatricule(view.getMatricule());
		employe.setEntreprise(entreprise);
		employe.setGrade(grade);
		employe.setProfilRemuneration(profil);
		
		remunerationEmployeRepository.save(employe);
		
	}
}
