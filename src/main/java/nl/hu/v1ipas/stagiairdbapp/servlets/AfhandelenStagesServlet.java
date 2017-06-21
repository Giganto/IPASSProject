package nl.hu.v1ipas.stagiairdbapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hu.v1ipas.stagiairdbapp.domain.ServiceProvider;
import nl.hu.v1ipas.stagiairdbapp.domain.StageService;

@WebServlet(urlPatterns = "/Afhandelen.do")
public class AfhandelenStagesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<String> stages = new ArrayList<String>();

		StageService service = ServiceProvider.getStageService();

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println(" <head><link rel=\"stylesheet\" type=\"text/css\" href=\"StyleSheet.css\"></title>");
		out.println(" <title>Stages geüpdatet.</title></head>");
		out.println(" <body>");
		out.println(" <h2>De stages zijn aangepast of verwijdert, klik op onderstaande link om terug naar Home te gaan of sluit uw browser.</h2>");
		out.println(" <a href=index.html>Terug naar Home</a>");
		out.println(" </body>");
		out.println("</html>");

		try {
			stages = service.getStageEnStagiair();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int i = stages.size();

		for (int x = 0; x < i; x += 6) {
			String keuze = req.getParameter("Afgerond" + x);
			if (keuze != null) {
				try {
					int y = Integer.parseInt(stages.get(x + 5));
					service.updateStage(y);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		for (int x = 0; x < i; x += 6) {
			String keuze = req.getParameter("Verwijderen" + x);
			if (keuze != null) {
				try {
					int y = Integer.parseInt(stages.get(x + 5));
					service.deleteStageEnStagiair(y);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
