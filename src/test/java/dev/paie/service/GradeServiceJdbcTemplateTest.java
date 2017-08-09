package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.JeuxDeDonneesConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;

@ContextConfiguration(classes = { ServicesConfig.class, JeuxDeDonneesConfig.class, DataSourceMySQLConfig.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		String nvCode = getRandomCode();
		BigDecimal nbHeuresBase = getRandom(139);
		BigDecimal tauxBase = getRandom(50.0);

		Grade grade = new Grade(nvCode, nbHeuresBase, tauxBase);
		
		boolean insertOrUpdate = false;
		List<Grade> grades = gradeService.lister();
		try (Stream<Grade> stream = grades.stream()){
			List<Grade> gradesByCode = stream.filter(g -> g.getCode().equals(nvCode)).collect(Collectors.toList());
			if (gradesByCode.isEmpty()){
				gradeService.sauvegarder(grade);
				insertOrUpdate = true;
			}
			else {
				Grade oldGrade = gradesByCode.get(0);
				oldGrade.setCode(grade.getCode());
				oldGrade.setNbHeuresBase(grade.getNbHeuresBase());
				oldGrade.setTauxBase(grade.getTauxBase());
				
				gradeService.mettreAJour(oldGrade);
				insertOrUpdate = true;
			}
		}
		assertTrue("Le grade de code "+grade.getCode()+" n'a pas été inséré ou mis à jour en base", insertOrUpdate);
	}

	public String getRandomCode() {
		return "E"+round(random()*10);
	}
	
	public BigDecimal getRandom(int base) {
		return new BigDecimal(round(random()*base));
	}
	
	public BigDecimal getRandom(double base) {
		return new BigDecimal(random()*base);
	}
}
