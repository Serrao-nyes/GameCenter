package it.unical.mat.webcomp21.persistence.dao;

import java.util.List;

import it.unical.mat.webcomp21.model.GiocoPosseduto;

public interface GiocoPossedutoDAO {
	
	public void save(GiocoPosseduto gd);  // Create
	public GiocoPosseduto findByPrimaryKey(long id);     // Retrieve
	public List<GiocoPosseduto> findAll();       
	public void update(GiocoPosseduto gd); //Update
	public void delete(GiocoPosseduto gd); //Delete	

}
