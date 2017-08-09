package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.config.JeuxDeDonneesConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;
import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;

@ContextConfiguration(classes = { ServicesConfig.class, JeuxDeDonneesConfig.class, DataSourceMySQLConfig.class, JpaConfig.class })
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest extends AbstractTest {

	@Autowired
	private CotisationService cotisationService;

	@Test
	@Transactional
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		String nvCode = getRandomCode("C");
		
		Cotisation cotisation = new Cotisation();
		cotisation.setCode(nvCode);
		cotisation.setLibelle(nvCode);
		cotisation.setTauxPatronal(getRandom(0.25));
		cotisation.setTauxSalarial(getRandom(0.25));
		
		List<Cotisation> cotisations = cotisationService.lister();
		boolean insertOrUpdate = false;
		try (Stream<Cotisation> stream = cotisations.stream()){
			List<Cotisation> cotisationsByCode = stream.filter(g -> g.getCode().equals(nvCode)).collect(Collectors.toList());
			if (cotisationsByCode.isEmpty()){
				cotisationService.sauvegarder(cotisation);
				insertOrUpdate = true;
			}
			else {
	
				cotisationService.mettreAJour(cotisation);
				insertOrUpdate = true;
			}
		}
		assertTrue("La cotisation de code "+cotisation.getCode()+" n'a pas été insérée ou mise à jour en base", insertOrUpdate);
	}
}
