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
								   @RequestParam String confermaPassword, @RequestParam String email) {
//		if(!password.equals(confermaPassword))
//			return "Le due password inserite non coincidono";
		Utente utenteUsername = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
		Utente utenteEmail = DBManager.getInstance().utenteDAO().findByEmail(email);
		if(utenteUsername != null && utenteEmail != null)
			return "Username ed email gia esistenti";
		if(utenteUsername != null && utenteEmail == null)
			return "Username gia esistente";
		if(utenteUsername == null && utenteEmail != null)
			return "Email gia esistente";
		String user = session.getAttribute("usernamelogged").toString();
		Utente utenteAttuale = DBManager.getInstance().utenteDAO().findByPrimaryKey(user);
//		System.out.println(utenteAttuale.getPassword());
		Utente utenteAggiornato = new Utente();
		utenteAggiornato.setUser(username);
		utenteAggiornato.setPassword(password);
		utenteAggiornato.setEmail(email);
//		utenteAggiornato.setNome(nome);
//		utenteAggiornato.setCognome(cognome);
		DBManager.getInstance().utenteDAO().update(utenteAggiornato, utenteAttuale);
		if(!username.equals(""))
			session.setAttribute("usernamelogged", username);
//		if(!nome.equals(""))
//			session.setAttribute("nomeUtente", nome);
		return "Modifiche effettuate con successo";
	}
	
	@GetMapping("doImpostazioni")
	public String impostazioni(){
		return "setting";
	}

}
