package dev.paie.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.paie.entite.Grade;

/** Mapper pour créer des instances de {@link Grade} à partir des données de la table GRADES
 * @author DIGINAMIC
 */
public class GradeMapper implements RowMapper<Grade> {
	
	@Override
	public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
		Grade p = new Grade();
		p.setId(rs.getInt("ID"));
		p.setCode(rs.getString("CODE"));
		p.setNbHeuresBase(rs.getBigDecimal("NB_HEURES_BASE"));
		p.setTauxBase(rs.getBigDecimal("TAUX_BASE"));
		return p;
	}
}