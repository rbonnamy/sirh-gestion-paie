package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	/** paieUtils : PaieUtils */
	@Autowired(required = true)
	private PaieUtils paieUtils;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {

		ResultatCalculRemuneration remu = new ResultatCalculRemuneration();
		Grade grade = bulletin.getRemunerationEmploye().getGrade();

		BigDecimal salaireBase = grade.getNbHeuresBase().multiply(grade.getTauxBase());
		BigDecimal salaireBrut = salaireBase.add(BigDecimal.valueOf(bulletin.getPrimeExceptionnelle()));

		BigDecimal totalRetenueSalariale = BigDecimal.ZERO;
		BigDecimal totalCotisationsPatronales = BigDecimal.ZERO;

		try (Stream<Cotisation> cotisationsNonImposables = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream()) {
			
			BinaryOperator<BigDecimal> binaryOperator = BigDecimal::add;
			totalRetenueSalariale = cotisationsNonImposables.filter(c -> c.getTauxSalarial() != null)
														    .map(c -> c.getTauxSalarial().multiply(salaireBrut))
														    .reduce(BigDecimal.ZERO, binaryOperator);
		}

		try (Stream<Cotisation> cotisationsNonImposables = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream()) {

			BinaryOperator<BigDecimal> binaryOperator = BigDecimal::add;
			totalCotisationsPatronales = cotisationsNonImposables.filter(c -> c.getTauxPatronal() != null)
																 .map(c -> c.getTauxPatronal().multiply(salaireBrut))
																 .reduce(BigDecimal.ZERO, binaryOperator);
		}

		BigDecimal totalCotisationsImposables = BigDecimal.ZERO;

		try (Stream<Cotisation> cotisationsImposables = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsImposables().stream()) {

			totalCotisationsImposables = cotisationsImposables.filter(c -> c.getTauxSalarial() != null)
															  .map(c -> c.getTauxSalarial().multiply(salaireBrut))
															  .reduce(BigDecimal.ZERO, BigDecimal::add);
		}

		BigDecimal netImposable = salaireBrut.subtract(totalRetenueSalariale);
		BigDecimal netAPayer = netImposable.subtract(totalCotisationsImposables);

		remu.setSalaireDeBase(paieUtils.formaterBigDecimal(salaireBase));
		remu.setSalaireBrut(paieUtils.formaterBigDecimal(salaireBrut));
		remu.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(totalRetenueSalariale));
		remu.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(totalCotisationsPatronales));
		remu.setNetImposable(paieUtils.formaterBigDecimal(netImposable));
		remu.setNetAPayer(paieUtils.formaterBigDecimal(netAPayer));
		return remu;
	}

	/**
	 * Getter for paieUtils
	 * 
	 * @return the paieUtils
	 */
	public PaieUtils getPaieUtils() {
		return paieUtils;
	}

	/**
	 * Setter
	 * 
	 * @param paieUtils
	 *            the paieUtils to set
	 */
	public void setPaieUtils(PaieUtils paieUtils) {
		this.paieUtils = paieUtils;
	}

}
