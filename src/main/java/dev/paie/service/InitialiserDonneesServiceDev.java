package dev.paie.service;

import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.Role;
import dev.paie.factory.UtilisateurFactory;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private CotisationRepository cotisationRepository;

	@Autowired
	private EntrepriseRepository entrepriseRepository;

	@Autowired
	private GradeRepository gradeRepository;

	@Autowired
	private ProfilRemunerationRepository profilRepository;

	@Autowired
	private PeriodeRepository periodeRepository;

	@Autowired
	private RemunerationEmployeRepository employeRepository;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UtilisateurFactory utilisateurFactory;

	// @PostConstruct : pas conseillé ici si jamais le PostConstruct est exécuté
	// entre la conf JDBC et la conf JPA
	// alors dans ce cas on initialisera la BDD puis la conf JPA fera un drop
	// and create.
	@Override
	@Transactional
	public void initialiser() {
		Map<String, Cotisation> beansOfTypeCotisation = context.getBeansOfType(Cotisation.class);
		beansOfTypeCotisation.values().forEach(c -> cotisationRepository.save(c));

		Map<String, Entreprise> beansOfTypeEntreprise = context.getBeansOfType(Entreprise.class);
		beansOfTypeEntreprise.values().forEach(e -> entrepriseRepository.save(e));

		Map<String, Grade> beansOfTypeGrade = context.getBeansOfType(Grade.class);
		beansOfTypeGrade.values().forEach(g -> gradeRepository.save(g));

		Map<String, ProfilRemuneration> beansOfTypeProfil = context.getBeansOfType(ProfilRemuneration.class);
		beansOfTypeProfil.values().forEach(p -> profilRepository.save(p));

		IntStream.iterate(1, i -> i + 1).limit(12).forEach(i -> periodeRepository.save(new Periode(i)));

		RemunerationEmploye employe = new RemunerationEmploye();
		employe.setMatricule("M01");
		employe.setEntreprise(beansOfTypeEntreprise.values().iterator().next());
		employe.setProfilRemuneration(beansOfTypeProfil.values().iterator().next());
		employe.setGrade(beansOfTypeGrade.values().iterator().next());
		employeRepository.save(employe);
		
		
		// Utilisateurs
		entityManager.persist(utilisateurFactory.getUtilisateur("root", "root", Role.ROLE_ADMINISTRATEUR));
		entityManager.persist(utilisateurFactory.getUtilisateur("richard", "toto", Role.ROLE_UTILISATEUR));
	}

	@Override
	public void initialiserEntityManager() {

		Stream.of(Cotisation.class, Entreprise.class, Grade.class, ProfilRemuneration.class)
				.forEach(classe -> context.getBeansOfType(classe).forEach((key, bean) -> entityManager.persist(bean)));

		IntStream.iterate(1, i -> i + 1).limit(12).forEach(i -> periodeRepository.save(new Periode(i)));
	}

	public void traitePersistence(Class<?> classe) {
		context.getBeansOfType(classe).values().forEach(c -> entityManager.persist(c));
	}

}
