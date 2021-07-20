package it.unical.mat.webcomp21.persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;

import it.unical.mat.webcomp21.model.GiocoPosseduto;
import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBSource;
import it.unical.mat.webcomp21.persistence.dao.GiocoPossedutoDAO;

public class GiocoPossedutoDAOJDBC implements GiocoPossedutoDAO {
	
	private DBSource dbSource;

	public GiocoPossedutoDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public void save(GiocoPosseduto giocoPosseduto) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO giocoposseduto VALUES(?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1, giocoPosseduto.getId());
			st.setString(2, giocoPosseduto.getNome());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public GiocoPosseduto findByPrimaryKey(int id) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM giocoposseduto WHERE id = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				GiocoPosseduto gp = new GiocoPosseduto();
				gp.setId(rs.getLong("id"));
				gp.setNome(rs.getString("nome"));
				conn.close();
				return gp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<GiocoPosseduto> findAll() {
		List<GiocoPosseduto> giochiPosseduti = new ArrayList<GiocoPosseduto>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM giocoposseduto";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				GiocoPosseduto gp = new GiocoPosseduto();
				gp.setId(rs.getLong("id"));
				gp.setNome(rs.getString("nome"));
				giochiPosseduti.add(gp);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return giochiPosseduti;
	}

	@Override
	public void update(GiocoPosseduto giocoPosseduto) {
		try {
			Connection conn = dbSource.getConnection();
			String update = "UPDATE giocoposseduto SET id = ?, nome = ? WHERE id = ?";
			PreparedStatement st = conn.prepareStatement(update);
			st.setLong(1, giocoPosseduto.getId());
			st.setString(2, giocoPosseduto.getNome());
			st.setLong(3, giocoPosseduto.getId());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(GiocoPosseduto giocoPosseduto) {
		try {
			Connection conn = dbSource.getConnection();
			String delete = "DELETE FROM giocoposseduto WHERE id = ? ";
			PreparedStatement st = conn.prepareStatement(delete);
			st.setLong(1, giocoPosseduto.getId());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
