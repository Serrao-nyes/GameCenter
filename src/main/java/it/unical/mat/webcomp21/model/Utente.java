package it.unical.mat.webcomp21.model;

import java.util.List;

public class Utente {
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String nome;
	
	private String cognome;
	
	private List<GiocoPosseduto> giochiPosseduti;
	
	private List<GiocoDesiderato> giochiDesiderati;
	
	public void setUser(String username) {
		this.username = username;
	}

	public String getUser() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<GiocoPosseduto> getGiochiPosseduti() {
		return giochiPosseduti;
	}

	public void setGiochiPosseduti(List<GiocoPosseduto> giochiPosseduti) {
		this.giochiPosseduti = giochiPosseduti;
	}

	public List<GiocoDesiderato> getGiochiDesiderati() {
		return giochiDesiderati;
	}

	public void setGiochiDesiderati(List<GiocoDesiderato> giochiDesiderati) {
		this.giochiDesiderati = giochiDesiderati;
	}

}
