package it.unical.mat.webcomp21.gamecenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;

@Controller
public class RegistrazioneController {
	

	@PostMapping("doRegistrazione")
	@ResponseBody
	public String registrazione(@RequestParam String username, @RequestParam String password, @RequestParam String email,
								 @RequestParam String nome, @RequestParam String cognome) {

		Utente utenteUsername = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
		Utente utenteEmail = DBManager.getInstance().utenteDAO().findByEmail(email);
		if(utenteUsername != null && utenteEmail != null)
			return "Username ed email gia' esistenti";
		if(utenteUsername != null && utenteEmail == null)
			return "Username gia' esistente";
		if(utenteUsername == null && utenteEmail != null)
			return "Email gia' esistente";
		Utente nuovoUtente = new Utente();
		nuovoUtente.setUser(username);
		nuovoUtente.setPassword(password);
		nuovoUtente.setEmail(email);
		nuovoUtente.setNome(nome);
		nuovoUtente.setCognome(cognome);
		DBManager.getInstance().utenteDAO().save(nuovoUtente);
		return "Registrazione effettuata con successo";
	} 
	
	@GetMapping("goToRegistrazione")
	public String registrazione() {
		return "signup";
	}
	


}
