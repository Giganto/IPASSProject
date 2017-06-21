package nl.hu.v1ipas.stagiairdbapp.domain;

import java.util.Date;

public class Stage {
	private int stageNr;
	private Date einddatum; 
	private String duur;
	private String niveau;
	private String type;
	private int afdelingNr;
	private int stagiairNr;
	private String status;

	public Stage (Date ed, String dr, String nv, String tp, int aNr, int stNr) {
		einddatum = ed;
		duur = dr;
		niveau = nv;
		type = tp;
		afdelingNr = aNr;
		stagiairNr = stNr;
	}
	
	public Stage (int sNr, Date ed,String dr, String nv, String tp, int aNr, int srNr, String st) {
		stageNr = sNr;
		einddatum = ed;
		duur = dr;
		niveau = nv;
		type = tp;
		afdelingNr = aNr;
		stagiairNr = srNr;
		status = st;
	}
	
	public int getStageNr() {
		return stageNr;
	}

	public void setStageNr(int stageNr) {
		this.stageNr = stageNr;
	}
	
	public Date getEinddatum() {
		return einddatum;
	}

	public void setEinddatum(Date einddatum) {
		this.einddatum = einddatum;
	}
	
	public String getDuur() {
		return duur;
	}

	public void setDuur(String duur) {
		this.duur = duur;
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

	public int getAfdelingNr() {
		return afdelingNr;
	}

	public void setAfdelingNr(int afdelingNr) {
		this.afdelingNr = afdelingNr;
	}

	public int getStagiairNr() {
		return stagiairNr;
	}

	public void setStagiairNr(int stagiairNr) {
		this.stagiairNr = stagiairNr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
