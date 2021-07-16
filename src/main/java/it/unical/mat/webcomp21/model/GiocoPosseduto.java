package it.unical.mat.webcomp21.model;

public class GiocoPosseduto {
	
	private int id;
	
	private boolean giocato;
	
	private boolean completato;

	public int getId() {
		return id;
	}

	public void setId(int idGioco) {
		this.id = idGioco;
	}

	public boolean isGiocato() {
		return giocato;
	}

	public void setGiocato(boolean giocato) {
		this.giocato = giocato;
	}

	public boolean isCompletato() {
		return completato;
	}

	public void setCompletato(boolean completato) {
		this.completato = completato;
	}

}
