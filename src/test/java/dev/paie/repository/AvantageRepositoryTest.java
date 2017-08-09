package dev.paie.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.service.AbstractTest;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest extends AbstractTest {

	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	@Transactional
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		Avantage avt = new Avantage();
		avt.setCode(getRandomCode("A"));
		avt.setMontant(getRandom(100).intValue());
		avt.setNom(getRandomCode("L"));
		
		boolean insertOrUpdate = false;
		
		Avantage avtDb = avantageRepository.findByCodeIgnoreCase(avt.getCode());
		if (avtDb==null){
			Avantage newOne = avantageRepository.save(avt);
			Avantage avtCreated = avantageRepository.findOne(newOne.getId());
			assertNotNull(avtCreated);
			
			assertThat(avtCreated.getCode(), equalTo(avt.getCode()));
			assertThat(avtCreated.getNom(), equalTo(avt.getNom()));
			assertThat(avtCreated.getMontant(), equalTo(avt.getMontant()));
			
			insertOrUpdate = true;
		}
		else {
			avtDb.setMontant(avt.getMontant());
			avtDb.setNom(avt.getNom());
			avantageRepository.saveAndFlush(avtDb);
			
			
			Avantage avtUpdated = avantageRepository.findOne(avtDb.getId());
			assertThat(avtUpdated.getCode(), equalTo(avt.getCode()));
			assertThat(avtUpdated.getNom(), equalTo(avt.getNom()));
			assertThat(avtUpdated.getMontant(), equalTo(avt.getMontant()));
			
			insertOrUpdate = true;
		}
		
		assertTrue(insertOrUpdate);
	}
}
