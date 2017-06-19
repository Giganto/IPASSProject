package nl.hu.v1ipas.stagiairdbapp.domain;

public class ServiceProvider {
	private static StageService stageService = new StageService();
	
	public static StageService getStageService() {
		return stageService;
	}
}
