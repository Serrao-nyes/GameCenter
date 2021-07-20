package it.unical.mat.webcomp21.gamecenter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;

@Controller
public class LoginController {
	
	@GetMapping("goToLogin")
	public String goTologin() {

		return "login";
	}


	@PostMapping("doLogin")
	@ResponseBody
	public String login(HttpSession session, @RequestParam String username, @RequestParam String password) {
		Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
		if((utente != null) && BCrypt.checkpw(password, utente.getPassword())) {
			session.setAttribute("usernameLogged", username);
			return "Login effettuato con successo";
		}
		return "Login fallito";
	}
	
	@GetMapping("doLogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}

}
