package it.unical.mat.webcomp21.persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unical.mat.webcomp21.model.GiocoDesiderato;
import it.unical.mat.webcomp21.model.GiocoPosseduto;
import it.unical.mat.webcomp21.persistence.DBSource;
import it.unical.mat.webcomp21.persistence.dao.GiocoDesideratoDAO;

public class GiocoDesideratoDAOJDBC implements GiocoDesideratoDAO {
	
	private DBSource dbSource;

	public GiocoDesideratoDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public void save(GiocoDesiderato giocoDesiderato) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO giocodesiderato VALUES(?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1, giocoDesiderato.getId());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public GiocoDesiderato findByPrimaryKey(int id) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM giocoposseduto WHERE id=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				GiocoDesiderato gp = new GiocoDesiderato();
				gp.setId(rs.getInt("id"));
				conn.close();
				return gp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<GiocoDesiderato> findAll() {
		List<GiocoDesiderato> giochiDesiderati = new ArrayList<GiocoDesiderato>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM giocodesiderato";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				GiocoDesiderato gp = new GiocoDesiderato();
				gp.setId(rs.getLong("id"));
				giochiDesiderati.add(gp);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return giochiDesiderati;
	}

	@Override
	public void update(GiocoDesiderato giocoDesiderato) {
		try {
			Connection conn = dbSource.getConnection();
			String update = "UPDATE giocodesiderato SET id = ? WHERE id = ?";
			PreparedStatement st = conn.prepareStatement(update);
			st.setLong(1, giocoDesiderato.getId());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void delete(GiocoDesiderato giocoDesiderato) {
		try {
			Connection conn = dbSource.getConnection();
			String delete = "DELETE FROM giocodesiderato WHERE id = ? ";
			PreparedStatement st = conn.prepareStatement(delete);
			st.setLong(1, giocoDesiderato.getId());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
