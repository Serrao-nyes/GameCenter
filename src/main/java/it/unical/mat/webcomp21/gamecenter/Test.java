package it.unical.mat.webcomp21.gamecenter;

import org.springframework.security.crypto.bcrypt.BCrypt;

import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;

public class Test {
	
	public static void main(String[] args) {
		String password = "prova";
		String risultato = BCrypt.hashpw("prova", BCrypt.gensalt(12));
		System.out.println(risultato);
		if(BCrypt.checkpw(password, risultato)) {
			System.out.println("Password corretta!");
		}
		else
			System.out.println("Password sbagliata!");
		Utente u = new Utente();
		u.setUser("prova");
		u.setPassword("prova");
		u.setEmail("prova@prova");
		u.setNome("Mario");
		u.setCognome("Rossi");
		DBManager.getInstance().utenteDAO().save(u);
//		Utente u = new Utente();
//		u.setUser("prova");
//		DBManager.getInstance().utenteDAO().delete(u);
	}
	
}
