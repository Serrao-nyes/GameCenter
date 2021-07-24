package it.unical.mat.webcomp21.gamecenter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.*;

import it.unical.mat.webcomp21.model.GiocoDesiderato;
import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;

@RestController
public class GiochiDesideratiController {
	
	@PostMapping("doGiochiDesiderati")
	public Boolean giochiDesiderati(HttpSession session, @RequestParam long idGiocoDesiderato, @RequestParam String nomeGiocoDesiderato) {

		GiocoDesiderato giocoDesiderato = new GiocoDesiderato();
		giocoDesiderato.setId(idGiocoDesiderato);
		giocoDesiderato.setNome(nomeGiocoDesiderato);
		if(session.getAttribute("usernamelogged") != null) {
			String username = session.getAttribute("usernamelogged").toString();
			Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
			GiocoDesiderato gd = DBManager.getInstance().giocoDesideratoDAO().findByPrimaryKey(idGiocoDesiderato);
			if(gd == null)
				DBManager.getInstance().giocoDesideratoDAO().save(giocoDesiderato);
			DBManager.getInstance().utenteDAO().addGiochiDesiderati(utente, giocoDesiderato);
			return true;
		}
		return false;
	}
	
	@PostMapping("removeGiochiDesiderati")
	public Boolean removeGiochiDesiderati(HttpSession session, @RequestParam long idGiocoDesiderato, @RequestParam String nomeGiocoDesiderato) {
		GiocoDesiderato giocoDesiderato = new GiocoDesiderato();
		giocoDesiderato.setId(idGiocoDesiderato);
		giocoDesiderato.setNome(nomeGiocoDesiderato);
		if(session.getAttribute("usernamelogged") != null) {
			String username = session.getAttribute("usernamelogged").toString();
			Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
			DBManager.getInstance().utenteDAO().removeGiochiDesiderati(utente, giocoDesiderato);
			if(!DBManager.getInstance().utenteDAO().findGiocoDesideratoById(idGiocoDesiderato))
				DBManager.getInstance().giocoDesideratoDAO().delete(giocoDesiderato);
			return true;
		}
		return false;
	}

}
