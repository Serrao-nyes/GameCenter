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
	public Boolean giochiDesiderati(HttpSession session, @RequestParam long idGiocodesiderato, @RequestParam String nomeGiocoDesiderato) {
		System.out.println("nyes");
		GiocoDesiderato giocoDesiderato = new GiocoDesiderato();
		Utente u = new Utente();
		u.setUser("prova");
		u.setPassword("prova");
		u.setEmail("prova@prova");
		u.setNome("Mario");
		u.setCognome("Rossi");
		giocoDesiderato.setId(idGiocodesiderato);
		giocoDesiderato.setNome(nomeGiocoDesiderato);
		DBManager.getInstance().giocoDesideratoDAO().save(giocoDesiderato);
		DBManager.getInstance().utenteDAO().addGiochiDesiderati(u, giocoDesiderato);
//		String username = session.getAttribute("usernameLogged").toString();
		/*if(session.getAttribute("usernameLogged").toString() != null) {
			Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
			DBManager.getInstance().utenteDAO().addGiochiDesiderati(utente, giocoDesiderato);
			return true;
		}*/
	//	return false;
		return true;
	}
	
	@PostMapping("removeGiochiDesiderati")
	public Boolean removeGiochiDesiderati(HttpSession session, @RequestParam long idGiocodesiderato, @RequestParam String nomeGiocoDesiderato) {
		GiocoDesiderato giocoDesiderato = new GiocoDesiderato();
		giocoDesiderato.setId(idGiocodesiderato);
		giocoDesiderato.setNome(nomeGiocoDesiderato);
		DBManager.getInstance().giocoDesideratoDAO().delete(giocoDesiderato);
		return true;
	}

}
