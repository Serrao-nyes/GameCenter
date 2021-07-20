package it.unical.mat.webcomp21.gamecenter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unical.mat.webcomp21.model.GiocoDesiderato;
import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;

@RestController
public class GiochiDesideratiController {
	
	@PostMapping("doGiochiDesiderati")
	public Boolean giochiDesiderati(HttpSession session, @RequestParam long idGiocoDesiderato, @RequestParam String nomeGiocoDesiderato) {
		System.out.println("nyes");
		GiocoDesiderato giocoDesiderato = new GiocoDesiderato();
		giocoDesiderato.setId(idGiocoDesiderato);
		giocoDesiderato.setNome(nomeGiocoDesiderato);
		if(session.getAttribute("usernameLogged") != null) {
			String username = session.getAttribute("usernameLogged").toString();
			Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
			GiocoDesiderato gd = DBManager.getInstance().giocoDesideratoDAO().findByPrimaryKey(idGiocoDesiderato);
			if(gd == null)
				DBManager.getInstance().giocoDesideratoDAO().save(giocoDesiderato);
			DBManager.getInstance().utenteDAO().addGiochiDesiderati(utente, giocoDesiderato);
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
	
	@PostMapping("removeGiochiDesiderati")
	public Boolean removeGiochiDesiderati(HttpSession session, @RequestParam long idGiocoDesiderato, @RequestParam String nomeGiocoDesiderato) {
		GiocoDesiderato giocoDesiderato = new GiocoDesiderato();
		giocoDesiderato.setId(idGiocoDesiderato);
		giocoDesiderato.setNome(nomeGiocoDesiderato);
		if(session.getAttribute("usernameLogged") != null) {
			String username = session.getAttribute("usernameLogged").toString();
			Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
			DBManager.getInstance().utenteDAO().removeGiochiDesiderati(utente, giocoDesiderato);
			//DBManager.getInstance().giocoDesideratoDAO().delete(giocoDesiderato);
			return true;
		}
		return false;
	}

}
