package nl.hu.v1ipas.stagiairdbapp.domain;

public class Afdeling {
	private String naam;
	private String hoofd;
	private String locatie;
	private int afdelingNr;

	public Afdeling(String nm, String hf, String loc, int aNr) {
		naam = nm;
		hoofd = hf;
		locatie = loc;
		afdelingNr = aNr;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getHoofd() {
		return hoofd;
	}

	public void setHoofd(String hoofd) {
		this.hoofd = hoofd;
	}

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}

	public int getAfdelingNr() {
		return afdelingNr;
	}

	public void setAfdelingNr(int afdelingNr) {
		this.afdelingNr = afdelingNr;
	}

	public String toString() {
		return "Afdeling: " + naam + "\nHoofd: " + hoofd + "\nLocatie: " + locatie + "\nAfdelingnummer: " + afdelingNr;
	}
}
