package nl.hu.v1ipas.stagiairdbapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hu.v1ipas.stagiairdbapp.domain.ServiceProvider;
import nl.hu.v1ipas.stagiairdbapp.domain.StageService;

@WebServlet(urlPatterns = "/AanmeldenStage.do")
public class AanmeldenStageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String voornaam = req.getParameter("Voornaam");
		String achternaam = req.getParameter("Achternaam");
		String plaats = req.getParameter("Plaats");
		String adres = req.getParameter("Adres");
		String afdeling = req.getParameter("Afdeling");
		String type = req.getParameter("Type");
		String niveau = req.getParameter("Niveau");
		String begindatum = req.getParameter("Begindatum");
		String einddatum = req.getParameter("Einddatum");
				
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println(" <head><link rel=\"stylesheet\" type=\"text/css\" href=\"StyleSheet.css\"></title>");
		out.println(" <title>Stage aangemeld</title></head>");
		out.println(" <body>");
		out.println(" <h2>Uw stage is aangemeld, klik op onderstaande link om terug naar Home te gaan of sluit uw browser.</h2>");
		out.println(" <a href=index.html>Terug naar Home</a>");
		out.println(" </body>");
		out.println("</html>");
		
		StageService service = ServiceProvider.getStageService();
		try {
			service.insertStagiair(voornaam, achternaam, plaats, adres, afdeling, type, niveau, begindatum, einddatum);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}