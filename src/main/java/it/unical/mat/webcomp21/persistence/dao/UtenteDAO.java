package it.unical.mat.webcomp21.persistence.dao;

import java.util.List;

import it.unical.mat.webcomp21.model.GiocoDesiderato;
import it.unical.mat.webcomp21.model.GiocoPosseduto;
import it.unical.mat.webcomp21.model.Utente;

public interface UtenteDAO {
	
	public void save(Utente utente);  // Create
	public Utente findByPrimaryKey(String username);    // Retrieve
	public Utente findByEmail(String email);
	public List<Utente> findAll();       
	public void update(Utente utenteAggiornato, Utente utenteAttuale); //Update
	public void delete(Utente utente); //Delete	
	public void addGiochiPosseduti(Utente utente, GiocoPosseduto giocoPosseduto);
	public void addGiochiDesiderati(Utente utente, GiocoDesiderato giocoDesiderato);
	public void removeGiochiPosseduti(Utente utente, GiocoPosseduto giocoPosseduto);
	public void removeGiochiDesiderati(Utente utente, GiocoDesiderato giocoDesiderato);
	public void giochiPosseduti(Utente utente);
	public void giochiDesiderati(Utente utente);
	public Boolean findGiocoDesideratoById(Long idGioco);
	public Boolean findGiocoPossedutoById(Long idGioco);
	public Boolean findGiocoDesideratoByUsernameAndId(String username, Long idGioco);
	public Boolean findGiocoPossedutoByUsernameAndId(String username, Long idGioco);
	
}
