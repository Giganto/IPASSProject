package nl.hu.v1ipas.stagiairdbapp.webservices;

import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import nl.hu.v1ipas.stagiairdbapp.domain.AfgerondeStage;
import nl.hu.v1ipas.stagiairdbapp.domain.ServiceProvider;
import nl.hu.v1ipas.stagiairdbapp.domain.StageService;

@Path("/AfgerondeStages")
public class AfgerondeStagesResource {
	@GET
	@Path("/Ophalen")
	@Produces("application/json")
	public String getStages() throws ParseException, SQLException {
		JsonArrayBuilder jab = Json.createArrayBuilder();

		ArrayList<AfgerondeStage> stages = new ArrayList<AfgerondeStage>();
		StageService service = ServiceProvider.getStageService();
		stages = service.getAfgerondeStages("Diergeneeskunde", "Afstudeerstage", "HBO", "2017-06-30");

		for (AfgerondeStage stage : stages) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("voornaam", stage.getVoornaam());
			job.add("achternaam", stage.getAchternaam());
			job.add("naam", stage.getNaam());
			job.add("niveau", stage.getNiveau());
			job.add("type", stage.getType());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}

	@POST
	@Path("/Sturen")
	@Produces("application/json")
	public String getStages(InputStream is) throws ParseException, SQLException {
		JsonObject object = Json.createReader(is).readObject();
		String afdeling = object.getString("afdeling");
		String type = object.getString("type");
		String niveau = object.getString("niveau");
		String einddatum = object.getString("einddatum");

		StageService service = ServiceProvider.getStageService();
		ArrayList<AfgerondeStage> stages = new ArrayList<AfgerondeStage>();
		stages = service.getAfgerondeStages(afdeling, type, niveau, einddatum);
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (AfgerondeStage stage : stages) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("voornaam", stage.getVoornaam());
			job.add("achternaam", stage.getAchternaam());
			job.add("naam", stage.getNaam());
			job.add("niveau", stage.getNiveau());
			job.add("type", stage.getType());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}

}