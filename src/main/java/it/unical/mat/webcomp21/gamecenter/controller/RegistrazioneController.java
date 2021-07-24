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
	
//	@PostMapping("doRegistrazione")
//	public String registrazione(Model model, @RequestParam String username, @RequestParam String password, @RequestParam String email,
//			 					@RequestParam String nome, @RequestParam String cognome) {
//		Utente utenteUsername = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
//		Utente utenteEmail = DBManager.getInstance().utenteDAO().findByEmail(email);
//	/*	if (utenteUsername!=null)
//		{System.out.println("Username nullo");}
//		if (utenteEmail!=null)
//		{System.out.println("Mail nullo");}*/
//		if(username.equals("") || password.equals("") || email.equals("") || nome.equals("") || cognome.equals(""))
//		{model.addAttribute("errore", "Tutti i campi devono essere riempiti");
//				return "signup";}
//		if(utenteUsername != null && utenteEmail != null) {
//			model.addAttribute("errore", "Username ed email già esistenti");
//			return "signup";
//		}
//
//		if(utenteUsername != null && utenteEmail == null) {
//			model.addAttribute("errore", "Username già esistente");
//			return "signup";
//		}
//		if(utenteUsername == null && utenteEmail != null) {
//			model.addAttribute("errore", "Email già esistente");
//			return "signup";
//		}
//		Utente nuovoUtente = new Utente();
//		nuovoUtente.setUser(username);
//		nuovoUtente.setPassword(password);
//		nuovoUtente.setEmail(email);
//		nuovoUtente.setNome(nome);
//		nuovoUtente.setCognome(cognome);
//		DBManager.getInstance().utenteDAO().save(nuovoUtente);
//		return "login";
//	}
	
	@PostMapping("doRegistrazione")
	@ResponseBody
	public String registrazione(@RequestParam String username, @RequestParam String password, @RequestParam String email,
								 @RequestParam String nome, @RequestParam String cognome) {
//		if(username.equals("") || password.equals("") || email.equals("") || nome.equals("") || cognome.equals("") ) {
//			System.out.println("username: " + username);
//			return "Tutti i campi devono essere compilati";
//		}
		Utente utenteUsername = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
		Utente utenteEmail = DBManager.getInstance().utenteDAO().findByEmail(email);
//		if(utenteEmail != null)
//			System.out.println("UtenteEmail Diverso da null");
//		else
//			System.out.println("UtenteEmail Uguale a null");
//		if(utenteUsername != null)
//			System.out.println("UtenteUsername Diverso da null");
//		else 
//			System.out.println("UtenteUsername Uguale a null");
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
//		System.out.println("USER: " + username);
//		System.out.println("PASS: " + password);
//		System.out.println("EM: " + email);
//		System.out.println("NOME: " + nome);
//		System.out.println("COGNOME: " + cognome);
		DBManager.getInstance().utenteDAO().save(nuovoUtente);
		return "Registrazione effettuata con successo";
	} 
	
	@GetMapping("goToRegistrazione")
	public String registrazione() {
		return "signup";
	}
	


}
