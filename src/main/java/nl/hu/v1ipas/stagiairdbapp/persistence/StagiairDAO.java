package nl.hu.v1ipas.stagiairdbapp.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nl.hu.v1ipas.stagiairdbapp.domain.Stagiair;

public class StagiairDAO extends BaseDAO {
	// Insert statement voor een Stagiair
	public void insertStagiair(Stagiair stagiair) throws SQLException {
		try (Connection c = super.getConnection()) {
			String sql = "insert into stagiair (stagiairnr, voornaam, achternaam, plaats, adres) "
					+ "values (nextval('stagiairnr'), '" + stagiair.getVoornaam() + "', '" + stagiair.getAchternaam()
					+ "', '" + stagiair.getPlaats() + "', '" + stagiair.getAdres() + "')";
			Statement myStmt = c.createStatement();
			myStmt.executeUpdate(sql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	// Delete statement voor een Stagiair
	public void deleteStagiair(int stagiairNr) throws SQLException {
		try (Connection c = super.getConnection()) {
			String sql = "delete from stagiair where stagiairnr = " + stagiairNr;
			Statement myStmt = c.createStatement();
			myStmt.executeQuery(sql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	
	// Hiermee krijg je het laatst ingevoerd stagiairnr, zodat deze bij het invoeren van een stage kan worden gebruikt.
	public int getStagiairNr() throws SQLException {
		try (Connection c = super.getConnection()) {
			String sql = "SELECT max(stagiairnr) as max FROM stagiair";
			Statement myStmt = c.createStatement();
			ResultSet rs = myStmt.executeQuery(sql);
			
			while (rs.next()) {
				return rs.getInt("max");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return 0;
	}
}
