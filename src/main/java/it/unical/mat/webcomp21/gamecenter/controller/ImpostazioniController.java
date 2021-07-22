package it.unical.mat.webcomp21.gamecenter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;

@RestController
public class ImpostazioniController {
	
	@GetMapping("doModificheAccount")
	
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
//		if(!username.equals(""))
//			session.setAttribute("usernamelogged", username);
		
		//if()
	}

}
