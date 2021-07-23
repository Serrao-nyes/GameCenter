package it.unical.mat.webcomp21.gamecenter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;

@RestController
public class GiochiPossedutiEDesideratiController {
	
	@PostMapping("doGiochiDesideratiEPosseduti")
	public String libreria(HttpSession session, @RequestParam Long idGioco) {
		if(session.getAttribute("usernamelogged") == null)
			return "Non è stato effettuato il login";
		String username = session.getAttribute("usernamelogged").toString();
		//Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
		Boolean giocoDesiderato = DBManager.getInstance().utenteDAO().findGiocoDesideratoByUsernameAndId(username, idGioco);
		Boolean giocoPosseduto = DBManager.getInstance().utenteDAO().findGiocoPossedutoByUsernameAndId(username, idGioco);
		if(giocoDesiderato && giocoPosseduto)
			return "Gioco salvato nei desiderati e nei posseduti";
		if(giocoDesiderato && !giocoPosseduto)
			return "Gioco salvato nei desiderati";
		if(!giocoDesiderato && giocoPosseduto)
			return "Gioco salvato nei posseduti";
		return "Gioco non salvato";

	}
	
}
