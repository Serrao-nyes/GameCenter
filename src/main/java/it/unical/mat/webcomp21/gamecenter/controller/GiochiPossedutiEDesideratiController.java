package it.unical.mat.webcomp21.gamecenter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unical.mat.webcomp21.persistence.DBManager;

@RestController
public class GiochiPossedutiEDesideratiController {
	
	@PostMapping("doGiochiDesideratiEPosseduti")
	public String libreria(HttpSession session, @RequestParam Long idGioco) {
		if(session.getAttribute("usernamelogged") == null && session.getAttribute("usernameloggedGoogle") == null )
			return "Non è stato effettuato il login";
		String username=null;
		if(session.getAttribute("usernamelogged")!=null)
		{
			username = session.getAttribute("usernamelogged").toString();
		}
		else
		{
			username = session.getAttribute("usernameloggedGoogle").toString();
		}
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
