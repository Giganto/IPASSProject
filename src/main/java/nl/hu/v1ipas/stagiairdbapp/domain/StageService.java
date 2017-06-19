package nl.hu.v1ipas.stagiairdbapp.domain;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import nl.hu.v1ipas.stagiairdbapp.persistence.StageDAO;
import nl.hu.v1ipas.stagiairdbapp.persistence.StagiairDAO;

public class StageService {
	private StageDAO stageDAO = new StageDAO();
	private StagiairDAO stagiairDAO = new StagiairDAO();

	// Insert een Stagiair en een Stage tegelijk, omdat ze aan elkaar verbonden
	// zijn.
	public void insertStagiair(String vn, String an, String pl, String ad, String af, String tp, String nv, String bd,
			String ed) throws SQLException, ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date einddatum;
		Date begindatum;
		try {
			einddatum = format.parse(ed);
			begindatum = format.parse(bd);
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		}
		System.out.println(einddatum);
		long diff = Math.abs(einddatum.getTime() - begindatum.getTime());
		long diffDays = diff / (24 * 60 * 60 * 1000);
		String duur;

		if (diffDays < 40) {
			duur = "Kwartaal";
		} else if (diffDays > 200) {
			duur = "Jaar";
		} else {
			duur = "Half jaar";
		}

		int aNr = Integer.parseInt(af);

		Stagiair nieuweStagiair = new Stagiair(vn, an, pl, ad);
		stagiairDAO.insertStagiair(nieuweStagiair);

		int stNr = stagiairDAO.getStagiairNr();
		Stage nieuweStage = new Stage(einddatum, duur, nv, tp, aNr, stNr);
		stageDAO.insertStage(nieuweStage);
	}

	public ArrayList<String> getStages() throws SQLException {
		ArrayList<String> stages = stageDAO.getStageEnStagiair();
		return stages;
	}

	public void updateStage(int stageNr) throws SQLException {
		stageDAO.updateStage(stageNr);
	}

	public void deleteStageEnStagiair(int stageNr) throws SQLException {
		int stagiairNr = stageDAO.getStagiairNr(stageNr);
		stageDAO.deleteStage(stageNr);
		stagiairDAO.deleteStagiair(stagiairNr);
	}

	// stages worden opgehaald. Begindatum wordt genegeerd omdat deze in het Proof of Concept verder niet nodig is. 
	public ArrayList<AfgerondeStage> getAfgerondeStages(String af, String tp, String nv, String bg, String ed) throws ParseException, SQLException {	
		ArrayList<AfgerondeStage> stages = stageDAO.getAfgerondeStages(af, tp, nv, bg, ed);
		return stages;
	}
}
