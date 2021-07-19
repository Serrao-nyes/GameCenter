package it.unical.mat.webcomp21.gamecenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;

@Controller
public class RegistrazioneController {
	
	@GetMapping("goToRegistrazione")
	public String registrazione() {
		return "signup";
	}
	
	@PostMapping("doRegistrazione") 
	public Boolean registrazione(@RequestParam String username, @RequestParam String password, @RequestParam String email,
								 @RequestParam String nome, @RequestParam String cognome) {
		Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
		if(utente == null)
			utente = DBManager.getInstance().utenteDAO().findByEmail(email);
		if(utente == null) {
			Utente nuovoUtente = new Utente();
			nuovoUtente.setUser(username);
			nuovoUtente.setPassword(password);
			nuovoUtente.setEmail(email);
			nuovoUtente.setNome(nome);
			nuovoUtente.setCognome(cognome);
			DBManager.getInstance().utenteDAO().save(utente);
			return true;
		}
		return false;
	} 
	

}
