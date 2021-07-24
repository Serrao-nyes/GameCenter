package it.unical.mat.webcomp21.gamecenter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.*;

import it.unical.mat.webcomp21.model.GiocoPosseduto;
import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;

@RestController
public class GiochiPossedutiController {
	
	@PostMapping("doGiochiPosseduti")
	public Boolean giochiPosseduti(HttpSession session, @RequestParam long idGiocoPosseduto, @RequestParam String nomeGiocoPosseduto) {
		GiocoPosseduto giocoPosseduto = new GiocoPosseduto();
		giocoPosseduto.setId(idGiocoPosseduto);
		giocoPosseduto.setNome(nomeGiocoPosseduto);
		if(session.getAttribute("usernamelogged") != null) {
			String username = session.getAttribute("usernamelogged").toString();
			Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
			GiocoPosseduto gp = DBManager.getInstance().giocoPossedutoDAO().findByPrimaryKey(idGiocoPosseduto);
			if(gp == null)
				DBManager.getInstance().giocoPossedutoDAO().save(giocoPosseduto);
			DBManager.getInstance().utenteDAO().addGiochiPosseduti(utente, giocoPosseduto);
			return true;
		}
		return false;

	}
	
	@PostMapping("removeGiochiPosseduti")
	public Boolean removeGiochiposseduti(HttpSession session, @RequestParam long idGiocoPosseduto, @RequestParam String nomeGiocoPosseduto) {
		GiocoPosseduto giocoPosseduto = new GiocoPosseduto();
		giocoPosseduto.setId(idGiocoPosseduto);
		giocoPosseduto.setNome(nomeGiocoPosseduto);
		if(session.getAttribute("usernamelogged") != null) {
			String username = session.getAttribute("usernamelogged").toString();
			Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
			DBManager.getInstance().utenteDAO().removeGiochiPosseduti(utente, giocoPosseduto);
			if(!DBManager.getInstance().utenteDAO().findGiocoPossedutoById(idGiocoPosseduto))
				DBManager.getInstance().giocoPossedutoDAO().delete(giocoPosseduto);
			return true;
		}
		return false;
	}



}

