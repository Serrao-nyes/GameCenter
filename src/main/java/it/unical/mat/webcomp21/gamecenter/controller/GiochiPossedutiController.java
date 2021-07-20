package it.unical.mat.webcomp21.gamecenter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unical.mat.webcomp21.model.GiocoPosseduto;
import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;

@RestController
public class GiochiPossedutiController {
	
	@PostMapping("doGiochiPosseduti")
	public Boolean giochiPosseduti(HttpSession session, @RequestParam long idGiocoPosseduto, @RequestParam String nomeGiocoPosseduto) {
		System.out.println("nyes");
		GiocoPosseduto giocoPosseduto = new GiocoPosseduto();
		giocoPosseduto.setId(idGiocoPosseduto);
		giocoPosseduto.setNome(nomeGiocoPosseduto);
		if(session.getAttribute("usernameLogged") != null) {
			String username = session.getAttribute("usernameLogged").toString();
			Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
			GiocoPosseduto gp = DBManager.getInstance().giocoPossedutoDAO().findByPrimaryKey(idGiocoPosseduto);
			if(gp == null)
				DBManager.getInstance().giocoPossedutoDAO().save(giocoPosseduto);
			DBManager.getInstance().utenteDAO().addGiochiPosseduti(utente, giocoPosseduto);
			return true;
		}
		return false;
//		Utente u = new Utente();
//		u.setUser("prova");
//		u.setPassword("prova");
//		u.setEmail("prova@prova");
//		u.setNome("Mario");
//		u.setCognome("Rossi");
//		String username = session.getAttribute("usernameLogged").toString();
		/*if(session.getAttribute("usernameLogged").toString() != null) {
			Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
			DBManager.getInstance().utenteDAO().addGiochiDesiderati(utente, giocoDesiderato);
			return true;
		}*/
	//	return false;
	}
	
	@PostMapping("removeGiochiPosseduti")
	public Boolean removeGiochiposseduti(HttpSession session, @RequestParam long idGiocoPosseduto, @RequestParam String nomeGiocoPosseduto) {
		GiocoPosseduto giocoPosseduto = new GiocoPosseduto();
		giocoPosseduto.setId(idGiocoPosseduto);
		giocoPosseduto.setNome(nomeGiocoPosseduto);
		if(session.getAttribute("usernameLogged") != null) {
			String username = session.getAttribute("usernameLogged").toString();
			Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
			DBManager.getInstance().utenteDAO().removeGiochiPosseduti(utente, giocoPosseduto);
			//DBManager.getInstance().giocoDesideratoDAO().delete(giocoDesiderato);
			return true;
		}
		return false;
	}

}

