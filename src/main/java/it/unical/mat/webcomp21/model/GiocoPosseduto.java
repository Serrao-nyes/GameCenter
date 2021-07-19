package it.unical.mat.webcomp21.model;

public class GiocoPosseduto {
	
	private long id;
	
	private boolean giocato;
	
	private boolean completato;

	public long getId() {
		return id;
	}

	public void setId(long idGioco) {
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
