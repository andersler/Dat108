package no.hvl.dat108;

import javax.persistence.Embedded;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "obl4")
public class Deltaker {
	

	
	private String fornavn;
	private String etternavn;
	
	@Id
	private String mobil;
    
    @Embedded
	private Passord passord;
    
    private String kjonn;
    
	
	public Deltaker(String fornavn,String etternavn,String mobil,Passord passord,String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.passord = passord;
		this.kjonn = kjonn;
	}
	
	public Deltaker() {
		
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public Passord getPassord() {
		return passord;
	}
	
	public String getKjonn() {
		return kjonn;
	}

	@Override
	public String toString() {
		return " [fornavn=" + fornavn + ", etternavn=" + etternavn +
				", mobil=" + mobil + ", passord=" + passord + ", kjønn=" + kjonn + "]";
	}
	
	
	

}
