package nl.hu.v1ipas.stagiairdbapp.domain;

public class Stagiair {
	private int stagiairNr;
	private String voornaam;
	private String achternaam;
	private String plaats;
	private String adres;

	public Stagiair(int sNr, String vn, String an, String pl, String ad) {
		stagiairNr = sNr;
		voornaam = vn;
		achternaam = an;
		plaats = pl;
		adres = ad;
	}
	
	public Stagiair(String vn, String an, String pl, String ad) {
		voornaam = vn;
		achternaam = an;
		plaats = pl;
		adres = ad;
	}

	public int getStagiairNr() {
		return stagiairNr;
	}

	public void setStagiairNr(int stagiairNr) {
		this.stagiairNr = stagiairNr;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getPlaats() {
		return plaats;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String toString() {
		return "stagiairNr: " + stagiairNr + "\nVoornaam: " + voornaam + "\nAchternaam: " + achternaam + "\nPlaats:"
				+ plaats + "\nAdres: " + adres;
	}
}
