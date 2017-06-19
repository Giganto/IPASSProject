package nl.hu.v1ipas.stagiairdbapp.domain;

public class AfgerondeStage {
	private String voornaam;
	private String achternaam;
	private String naam; // afdeling naam, consistent met de naamgeving in de database
	private String niveau;
	private String type;
	
	public AfgerondeStage(String vn, String an, String nm, String nv, String tp) {
		voornaam = vn;
		achternaam = an;
		naam = nm;
		niveau = nv;
		type = tp;
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

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
