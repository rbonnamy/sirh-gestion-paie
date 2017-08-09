package dev.paie.service;

import static java.lang.Math.random;
import static java.lang.Math.round;

import java.math.BigDecimal;

public abstract class AbstractTest {


	protected String getRandomCode(String prefix) {
		return prefix+round(random()*10);
	}
	
	protected BigDecimal getRandom(int base) {
		return new BigDecimal(round(random()*base));
	}
	
	protected BigDecimal getRandom(double base) {
		return new BigDecimal(random()*base);
	}
}
