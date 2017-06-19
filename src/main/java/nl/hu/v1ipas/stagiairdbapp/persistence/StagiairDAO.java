package nl.hu.v1ipas.stagiairdbapp.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nl.hu.v1ipas.stagiairdbapp.domain.Stagiair;

public class StagiairDAO extends BaseDAO {
	// Select statement voor een Stagiair.
	public Stagiair getStagiair(int sNr) throws SQLException {
		try (Connection c = super.getConnection()) {
			String sql = "select * from stagiair where stagiairnr = " + sNr;
			Statement myStmt = c.createStatement();
			ResultSet rs = myStmt.executeQuery(sql);

			while (rs.next()) {
				Stagiair stagiair = new Stagiair(rs.getInt("stagiairNr"), rs.getString("voornaam"),
						rs.getString("achternaam"), rs.getString("plaats"), rs.getString("adres"));
				return stagiair;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}

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
