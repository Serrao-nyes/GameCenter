package it.unical.mat.webcomp21.gamecenter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {

	@GetMapping("doAccount")
	public String account(HttpSession session, Model model) {
		String username = session.getAttribute("usernamelogged").toString();
		Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
		DBManager.getInstance().utenteDAO().giochiDesiderati(utente);
		if(utente.getGiochiDesiderati().size() > 0)
			model.addAttribute("giochiDesiderati", utente.getGiochiDesiderati());
		return "Account";

	}



	/*@GetMapping("account")
	public String acc()
	{return  "Account";}*/

}
