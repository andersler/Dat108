package no.hvl.dat108;


import javax.servlet.http.HttpServletRequest;

public class SkjemaBean {

	private String fornavn;
	private String etternavn;
	private String mobil;
	private String passord;
	private String passordrepetert;
	private String kjonn;

	private String fornavnFeilmelding;
	private String etternavnFeilmelding;
	private String mobilFeilmelding;
	private String passordFeilmelding;
	private String passordrepetertFeilmelding;
	private String kjonnFeilmelding;

	
	public SkjemaBean(HttpServletRequest request) {
		this.fornavn = request.getParameter("fornavn");
		this.etternavn = request.getParameter("etternavn");
		this.mobil = request.getParameter("mobil");
		this.passord = request.getParameter("passord");
		this.passordrepetert = request.getParameter("passordrepetert");
		this.kjonn = request.getParameter("kjonn");
	}

	Validator validator = new Validator();

	public synchronized boolean isAllInputGyldig() {
		return isFornavnGyldig() && isEtternavnGyldig() && isMobilGyldig() && isPassordGyldig()
				&& isPassordrepeterGyldig() && isKjonnGyldig();
	}

	private synchronized boolean isFornavnGyldig() {
		return validator.validForNavn(this.fornavn);
	}

	private synchronized boolean isEtternavnGyldig() {
		return validator.validEtterNavn(this.etternavn);
	}

	private synchronized boolean isMobilGyldig() {
		return validator.validMobil(this.mobil);
	}

	private synchronized  boolean isPassordGyldig() {

		return validator.validPassord(this.passord);

	}

	private synchronized boolean isPassordrepeterGyldig() {
		return isPassordGyldig() && this.passordrepetert.equals(this.passord);
	}

	private synchronized boolean isKjonnGyldig() {

		
		 if (kjonn!=null) {
			 
			   if (!kjonn.equals("mann")&&!kjonn.equals("kvinne")) {
				   return false;
			   }
			   
			   return true;
		 }
		 return false;
	}

	public synchronized void settOppFeilmeldinger() {

		if (!isFornavnGyldig()) {
			this.fornavn = "";
			this.fornavnFeilmelding = "Ugyldig Fornavn!";
		}
		if (!isEtternavnGyldig()) {
			this.etternavn = "";
			this.etternavnFeilmelding = "Ugyldig Etternavn!";
		}
		if (!isMobilGyldig()) {
			this.mobil = "";
			this.mobilFeilmelding = "Ugyldig mobilnr";
		}
		if (!isPassordGyldig()) {
			this.passord = "";
			this.passordFeilmelding = "Ugyldig passord";
		}

		if (!isPassordrepeterGyldig()) {
			this.passordrepetert = "";
			this.passordrepetertFeilmelding = "Ugyldig passord";
		}
		if (!isKjonnGyldig()) {
			this.kjonnFeilmelding = "Du må oppgi kjønn";
		}
	}
	

	public String getFornavn() {
		return this.fornavn;
	}

	public String getEtternavn() {
		return this.etternavn;
	}

	public String getMobil() {
		return this.mobil;
	}

	public String getPassord() {
		return this.passord;
	}

	public String getPassordrepetert() {
		return this.passordrepetert;
	}

	public String getKjonn() {
		return this.kjonn;
	}
	
	
	public String getFornavnFeilmelding() {
		return this.fornavnFeilmelding;
	}

	public String getEtternavnFeilmelding() {
		return this.etternavnFeilmelding;
	}

	public String getMobilFeilmelding() {
		return this.mobilFeilmelding;
	}

	public String getPassordFeilmelding() {
		return this.passordFeilmelding;
	}

	public String getPassordrepetertFeilmelding() {
		return this.passordrepetertFeilmelding;
	}
	
	public String getKjonnFeilmelding() {
		return this.kjonnFeilmelding;
	}
	

}
