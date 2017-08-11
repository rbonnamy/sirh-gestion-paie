package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.BulletinSalaireService;
import dev.paie.view.bulletin.BulletinSalaireView;
import dev.paie.view.bulletin.BulletinSalaireViewForVisualisation;

@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {
	
	@Autowired
	private BulletinSalaireService bulletinSalaireService;
	
	@Autowired
	private PeriodeRepository periodeRepository;
	
	@Autowired
	private RemunerationEmployeRepository employeRepository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("employes", employeRepository.findAll());
		mv.addObject("periodes", periodeRepository.findAll());
		mv.setViewName("bulletins/creerBulletin");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/detail")
	@Secured({"ROLE_ADMINISTRATEUR", "ROLE_UTILISATEUR"})
	public ModelAndView detailBulletin(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		
		BulletinSalaireViewForVisualisation bulletinView = bulletinSalaireService.buildDetailById(id);
		mv.addObject("bulletin", bulletinView);
		mv.setViewName("bulletins/visualiserBulletin");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, path = "/validerCreer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView validerCreerBulletin(BulletinSalaireView bulletinView) {
		
		bulletinSalaireService.creerBulletin(bulletinView);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("bulletins", bulletinSalaireService.findAll());
		mv.setViewName("bulletins/bulletins");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@Secured({"ROLE_ADMINISTRATEUR", "ROLE_UTILISATEUR"})
	public ModelAndView listeBulletins() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/bulletins");
		mv.addObject("bulletins", bulletinSalaireService.findAll());
		return mv;
	}
}
