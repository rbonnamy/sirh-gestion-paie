package dev.paie.service;

import java.util.List;

import dev.paie.view.bulletin.BulletinSalaireView;
import dev.paie.view.bulletin.BulletinSalaireViewForList;
import dev.paie.view.bulletin.BulletinSalaireViewForVisualisation;

public interface BulletinSalaireService {

	void creerBulletin(BulletinSalaireView view);

	List<BulletinSalaireViewForList> findAll();

	BulletinSalaireViewForVisualisation buildDetailById(int id);
}
