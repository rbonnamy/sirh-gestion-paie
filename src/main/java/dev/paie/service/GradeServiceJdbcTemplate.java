package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

/** Implémentation Spring JDBC de l'interface {@link GradeService}
 * @author DIGINAMIC
 */
@Service
public class GradeServiceJdbcTemplate implements GradeService {

	/** jdbcTemplate : JdbcTemplate */
	private JdbcTemplate jdbcTemplate;

	/** Constructeur
	 * @param dataSource source de données
	 */
	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO GRADES (CODE, NB_HEURES_BASE, TAUX_BASE) VALUES(?,?,?)";
		this.jdbcTemplate.update(sql, nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());

	}

	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE GRADES SET CODE = ?, NB_HEURES_BASE=?, TAUX_BASE=? WHERE ID = ? ";
		this.jdbcTemplate.update(sql, grade.getCode(), grade.getNbHeuresBase(), grade.getTauxBase(), grade.getId());
	}


	@Override
	public List<Grade> lister() {
		String sql = "SELECT * FROM GRADES";
		return this.jdbcTemplate.query(sql, new GradeMapper());
	}
}