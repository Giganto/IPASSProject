package nl.hu.v1ipas.stagiairdbapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hu.v1ipas.stagiairdbapp.domain.ServiceProvider;
import nl.hu.v1ipas.stagiairdbapp.domain.StageService;

@WebServlet(urlPatterns = "/VergoedingBerekenen.do")
public class VergoedingBerekenenServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<String> stages = new ArrayList<String>();

		String afdeling = req.getParameter("Afdeling");
		String type = req.getParameter("Type");
		String niveau = req.getParameter("Niveau");
		String begindatum = req.getParameter("Begindatum");
		String einddatum = req.getParameter("Einddatum");

		StageService service = ServiceProvider.getStageService();

		try {
			stages = service.getAfgerondeStages(afdeling, type, niveau, einddatum);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int i = stages.size();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println(" <head><link rel=\"stylesheet\" type=\"text/css\" href=\"StyleSheet.css\"></title>");
		out.println(" <title>Stages</title></head>");
		out.println(" <body>");
		out.println(" <h2>Dit zijn de afgeronde stages</h2>");
		out.println(
				" <table><tr><th>Voornaam</th><th>Achternaam</th><th>Afdeling</th><th>Niveau</th><th>Type</th><th>Vergoeding</th>");
		for (int x = 0; x < i; x += 5) {
			out.println("<tr><td>" + stages.get(x) + "</td><td>" + stages.get(x + 1) + "</td><td>" + stages.get(x + 2)
					+ "</td><td>" + stages.get(x + 3) + "</td><td>" + stages.get(x + 4) + "</td><td>€ 500,00</td></tr>");
		}
		out.println("</table>");
		out.println(" <a href=index.html>Terug naar Home</a>");
		out.println(" </body>");
		out.println("</html>");

	}
}
