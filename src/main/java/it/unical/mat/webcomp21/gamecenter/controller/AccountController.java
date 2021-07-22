package it.unical.mat.webcomp21.gamecenter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;

@Controller
public class AccountController {
	
	@GetMapping("doAccount")
	public String account(HttpSession session, Model model) {
		String username = session.getAttribute("usernamelogged").toString();
		Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
		DBManager.getInstance().utenteDAO().giochiDesiderati(utente);
		DBManager.getInstance().utenteDAO().giochiPosseduti(utente);
		if(utente.getGiochiDesiderati().size() > 0)
			model.addAttribute("giochiDesiderati", utente.getGiochiDesiderati());
		if(utente.getGiochiPosseduti().size() > 0)
			model.addAttribute("giochiPosseduti", utente.getGiochiPosseduti());
		return "Account";
	}

}
