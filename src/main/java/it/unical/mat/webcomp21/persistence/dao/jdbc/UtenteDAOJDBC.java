package it.unical.mat.webcomp21.persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;

import it.unical.mat.webcomp21.model.GiocoDesiderato;
import it.unical.mat.webcomp21.model.GiocoPosseduto;
import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;
import it.unical.mat.webcomp21.persistence.DBSource;
import it.unical.mat.webcomp21.persistence.dao.UtenteDAO;

public class UtenteDAOJDBC implements UtenteDAO {

	private DBSource dbSource;

	public UtenteDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public void save(Utente utente) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO utente VALUES(?, ?, ?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, utente.getUser());
			st.setString(2, BCrypt.hashpw(utente.getPassword(), BCrypt.gensalt(12)));
			st.setString(3, utente.getEmail());
			st.setString(4, utente.getNome());
			st.setString(5, utente.getCognome());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Utente findByPrimaryKey(String username) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM utente WHERE username=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				Utente utente = new Utente();
				utente.setUser(rs.getString("username"));
				utente.setPassword(rs.getString("password"));
				utente.setEmail(rs.getString("email"));
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));
				conn.close();
				return utente;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Utente> findAll() {
		List<Utente> utenti = new ArrayList<Utente>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM utente";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Utente utente = new Utente();
				utente.setUser(rs.getString("username"));
				utente.setPassword(rs.getString("password"));
				utente.setEmail(rs.getString("email"));
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));
				utenti.add(utente);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utenti;
	}

	@Override
	public void update(Utente utente) {
		try {
			Connection conn = dbSource.getConnection();
			String update = "UPDATE utente SET username = ?, password = ?, email = ?, nome = ?, cognome = ? WHERE matricola = ?";
			PreparedStatement st = conn.prepareStatement(update);
			st.setString(1, utente.getUser());
			st.setString(2, BCrypt.hashpw(utente.getPassword(), BCrypt.gensalt(12)));
			st.setString(3, utente.getEmail());			
			st.setString(4, utente.getNome());
			st.setString(5, utente.getCognome());
			st.setString(6, utente.getUser());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Utente utente) {
		try {
			Connection conn = dbSource.getConnection();
			String delete = "DELETE FROM studente WHERE username = ? ";
			PreparedStatement st = conn.prepareStatement(delete);
			st.setString(1, utente.getUser());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addGiochiPosseduti(Utente utente, GiocoPosseduto giocoPosseduto) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO possiede(utente,gioco) VALUES(?,?) RETURNING id";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, utente.getUser());
			st.setInt(2, giocoPosseduto.getId());	
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addGiochiDesiderati(Utente utente, GiocoDesiderato giocoDesiderato) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO desidera(utente,gioco) VALUES(?,?) RETURNING id";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, utente.getUser());
			st.setInt(2, giocoDesiderato.getId());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void removeGiochiPosseduti(Utente utente, GiocoPosseduto giocoPosseduto) {
		try {
			Connection conn = dbSource.getConnection();
			String delete = "DELETE FROM possiede WHERE utente = ? AND gioco = ?";
			PreparedStatement st = conn.prepareStatement(delete);
			st.setString(1, utente.getUser());
			st.setInt(2, giocoPosseduto.getId());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeGiochiDesiderati(Utente utente, GiocoDesiderato giocoDesiderato) {
		try {
			Connection conn = dbSource.getConnection();
			String delete = "DELETE FROM desidera WHERE utente = ? AND gioco = ?";
			PreparedStatement st = conn.prepareStatement(delete);
			st.setString(1, utente.getUser());
			st.setInt(2, giocoDesiderato.getId());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void giochiPosseduti(Utente utente) {
		List<GiocoPosseduto> giochiPosseduti = new ArrayList<GiocoPosseduto>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM possiede WHERE utente = ?";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int idGioco = rs.getInt("id");
				GiocoPosseduto gp = DBManager.getInstance().giocoPossedutoDAO().findByPrimaryKey(idGioco);
				giochiPosseduti.add(gp);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		utente.setGiochiPosseduti(giochiPosseduti);
	}

	@Override
	public void giochiDesiderati(Utente utente) {
		List<GiocoDesiderato> giochiDesiderati = new ArrayList<GiocoDesiderato>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM desidera WHERE utente = ?";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int idGioco = rs.getInt("id");
				GiocoDesiderato gd = DBManager.getInstance().giocoDesideratoDAO().findByPrimaryKey(idGioco);
				giochiDesiderati.add(gd);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		utente.setGiochiDesiderati(giochiDesiderati);
	}
	
}
