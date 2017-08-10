package dev.paie.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.view.bulletin.BulletinSalaireView;
import dev.paie.view.bulletin.BulletinSalaireViewForList;
import dev.paie.view.bulletin.BulletinSalaireViewForVisualisation;

@Service
@Transactional
public class BulletinSalaireServiceDev implements BulletinSalaireService {

	/** bulletinSalaireRepository : BulletinSalaireRepository */
	@Autowired
	private BulletinSalaireRepository bulletinSalaireRepository;
	
	@Autowired
	private PeriodeRepository periodeRepository;
	
	@Autowired
	private RemunerationEmployeRepository employeRepository;
	
	@Autowired
	private CalculerRemunerationService calculRemunerationService;
	
	@Override
	public void creerBulletin(BulletinSalaireView view) {
		
		String matricule = view.getMatricule();
		Periode periode = periodeRepository.findOne(view.getPeriodeId());
		RemunerationEmploye remunerationEmploye = employeRepository.findByMatriculeIgnoreCase(matricule);
		
		BulletinSalaire bulletinSalaire = new BulletinSalaire();
		bulletinSalaire.setPeriode(periode);
		bulletinSalaire.setRemunerationEmploye(remunerationEmploye);
		bulletinSalaire.setPrimeExceptionnelle(new BigDecimal(view.getPrimeExceptionnelle()));
		bulletinSalaire.setDateCreation(LocalDateTime.now(ZoneId.of("Europe/Paris")));
		
		bulletinSalaireRepository.save(bulletinSalaire);
		
	}

	@Override
	public List<BulletinSalaireViewForList> findAll() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		List<BulletinSalaireViewForList> liste = new ArrayList<>();
		
		List<BulletinSalaire> bulletins = bulletinSalaireRepository.findAll();
		bulletins.forEach(bulletin -> {
			
			ResultatCalculRemuneration resultat = calculRemunerationService.calculer(bulletin);
			
			BulletinSalaireViewForList view = new BulletinSalaireViewForList();
			view.setId(bulletin.getId());
			view.setDateCreation(formatter.format(bulletin.getDateCreation()));
			view.setMatricule(bulletin.getRemunerationEmploye().getMatricule());
			view.setPeriode(bulletin.getPeriode().getDateDebut()+" - " + bulletin.getPeriode().getDateFin());
			view.setNetAPayer(resultat.getNetAPayer());
			view.setSalaireBrut(resultat.getSalaireBrut());
			view.setNetImposable(resultat.getNetImposable());
			
			liste.add(view);
		});
		
		return liste;
	}

	@Override
	public BulletinSalaireViewForVisualisation buildDetailById(int id) {
		
		
		BulletinSalaire bulletin = bulletinSalaireRepository.findOne(id);
		ResultatCalculRemuneration resultat = calculRemunerationService.calculer(bulletin);
		
		BulletinSalaireViewForVisualisation view = new BulletinSalaireViewForVisualisation();
		view.setPeriode(bulletin.getPeriode().getDateDebut() +" - "+ bulletin.getPeriode().getDateFin());
		view.setRemunerationEmploye(bulletin.getRemunerationEmploye());
		view.setResultat(resultat);
		return view;
	}

}
