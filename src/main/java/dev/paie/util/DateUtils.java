package dev.paie.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/** Classe qui fournit des services de gestion de conversion String / LocalDate / LocalDateTime
 * @author DIGINAMIC
 */
public class DateUtils {

	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	/** Génère une LocalDate depuis une String 
	 * @param dateString chaine qui contient la date sous forme de String
	 * @param pattern format utilisé pour parser la date
	 * @return {@link LocalDate}
	 */
	public static LocalDate parse(String dateString, String pattern){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		formatter = formatter.withLocale(Locale.FRANCE);  		
		return LocalDate.parse(dateString, formatter);
	}
}
