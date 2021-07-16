package it.unical.mat.webcomp21.persistence.dao;

import java.util.List;

import it.unical.mat.webcomp21.model.GiocoDesiderato;
import it.unical.mat.webcomp21.model.GiocoPosseduto;
import it.unical.mat.webcomp21.model.Utente;

public interface UtenteDAO {
	
	public void save(Utente utente);  // Create
	public Utente findByPrimaryKey(String username);    // Retrieve
	public List<Utente> findAll();       
	public void update(Utente utente); //Update
	public void delete(Utente utente); //Delete	
	public void addGiochiPosseduti(Utente utente, GiocoPosseduto giocoPosseduto);
	public void addGiochiDesiderati(Utente utente, GiocoDesiderato giocoDesiderato);
	public void removeGiochiPosseduti(Utente utente, GiocoPosseduto giocoPosseduto);
	public void removeGiochiDesiderati(Utente utente, GiocoDesiderato giocoDesiderato);
	public void giochiPosseduti(Utente utente);
	public void giochiDesiderati(Utente utente);
	
}
