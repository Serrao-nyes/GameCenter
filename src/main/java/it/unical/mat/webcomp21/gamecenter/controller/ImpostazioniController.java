package it.unical.mat.webcomp21.gamecenter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;

@Controller
public class ImpostazioniController {
	
	@PostMapping("doModificheAccount")
	@ResponseBody
	public String modificheAccount(HttpSession session, @RequestParam String username,  @RequestParam String password, 
								   @RequestParam String confermaPassword, @RequestParam String email, @RequestParam String nome, 
								   @RequestParam String cognome) {
		if(!password.equals(confermaPassword))
			return "Le due password inserite non coincidono";
		String user = session.getAttribute("usernamelogged").toString();
		Utente utenteAttuale = DBManager.getInstance().utenteDAO().findByPrimaryKey(user);
		Utente utenteAggiornato = new Utente();
		utenteAggiornato.setUser(username);
		utenteAggiornato.setPassword(password);
		utenteAggiornato.setEmail(email);
		utenteAggiornato.setNome(nome);
		utenteAggiornato.setCognome(cognome);
		DBManager.getInstance().utenteDAO().update(utenteAggiornato, utenteAttuale);
		return "Modifiche effettuate con successo";
		if(!username.equals(""))
			session.setAttribute("usernamelogged", username);
		


	}
	@GetMapping("doImpostazioni")
	public String impostazioni(){
		return "setting";
	}

}
