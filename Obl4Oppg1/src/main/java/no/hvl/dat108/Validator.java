package no.hvl.dat108;

public class Validator {
	
	
	public static final String ANY_LETTER_AND_WHITESPACE = "^[A-Z][a-z]{2,}?[\\s\\-\\(A-Za-z)]*$";
	public static final String ANY_LETTER = "[A-ZÆØÅ][(a-zæøå){3,}]";
	public static final String ANY_LETTER_OR_DIGIT = "[A-Za-zÆØÅæøå\\d]";
	public static final String THREE_OR_MORE_TIMES = "{3,}";
	public static final String FOUR_OR_MORE_TIMES = "{4,}";
	public static final String EIGHT_NUMBERS = "\\d{8}$";
	
	public  boolean validForNavn(String streng) {
		
		if (streng.length() < 3 || streng.length()>=20) {
			return false;
		}
		
		return streng!=null && streng.matches("^" + ANY_LETTER_AND_WHITESPACE + "*$");
	}
	
	public  boolean validEtterNavn(String streng) {
		
		if (streng.length() <3 || streng.length()>=20) {
			return false;
		}

		
		return streng!=null && streng.matches("^" + ANY_LETTER + THREE_OR_MORE_TIMES + "$");
	}
	public boolean validPassord(String streng) {
		
		if (streng.length()<=3 ||streng.length()>=20) {
			return false;
		}
		return streng!= null && streng.matches("^" + ANY_LETTER_OR_DIGIT + FOUR_OR_MORE_TIMES + "$");
	}
	
	public boolean validMobil(String streng) {
	
		if (streng!=null && streng.length() == 8) {
			return true;
		}
		return false;
	}
	
	

}
