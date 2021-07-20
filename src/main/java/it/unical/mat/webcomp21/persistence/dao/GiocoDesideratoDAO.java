package it.unical.mat.webcomp21.persistence.dao;

import java.util.List;

import it.unical.mat.webcomp21.model.GiocoDesiderato;

public interface GiocoDesideratoDAO {
	
	public void save(GiocoDesiderato gd);  // Create
	public GiocoDesiderato findByPrimaryKey(long idGiocoDesiderato);     // Retrieve
	public List<GiocoDesiderato> findAll();       
	public void update(GiocoDesiderato gd); //Update
	public void delete(GiocoDesiderato gd); //Delete	

}
