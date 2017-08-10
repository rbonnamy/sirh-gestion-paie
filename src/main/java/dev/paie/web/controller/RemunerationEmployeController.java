package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.beanview.RemunerationEmployeView;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.RemunerationEmployeService;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	
	@Autowired
	private RemunerationEmployeRepository employeRepository;
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private ProfilRemunerationRepository profilRepository;
	
	@Autowired
	private RemunerationEmployeService remunerationEmployeService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("entreprises", entrepriseRepository.findAll());
		mv.addObject("grades", gradeRepository.findAll());
		mv.addObject("profils", profilRepository.findAll());
		mv.setViewName("employes/creerEmploye");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, path = "/validerCreer")
	public ModelAndView validerCreerEmploye( RemunerationEmployeView employeView) {
		
		remunerationEmployeService.creerEmploye(employeView);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("employes", employeRepository.findAll());
		mv.setViewName("employes/employes");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listeEmployes() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/employes");
		mv.addObject("employes", employeRepository.findAll());
		return mv;
	}
}
