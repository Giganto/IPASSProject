package nl.hu.v1ipas.stagiairdbapp.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nl.hu.v1ipas.stagiairdbapp.domain.Afdeling;

// Klase is alleen voor het ophalen van een Afdeling.

public class AfdelingDAO extends BaseDAO {
	// ophalen afdeling
	public Afdeling getAfdeling(int anr) throws SQLException {
		try (Connection c = super.getConnection()) {
		String sql = "select * from afdeling where afdelingnr = " + anr;
		Statement myStmt = c.createStatement();
		ResultSet rs = myStmt.executeQuery(sql);
		
		while (rs.next()) {
			Afdeling afdeling = new Afdeling(rs.getString("naam"), rs.getString("hoofd"), rs.getString("locatie"),
					rs.getInt("afdelingNr"));
			return afdeling;
		}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}

}
