package it.unical.mat.webcomp21.gamecenter;

import org.springframework.security.crypto.bcrypt.BCrypt;

import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;

public class Test {
	
	public static void main(String[] args) {
		String password = "prova";
		String risultato = BCrypt.hashpw("p", BCrypt.gensalt(12));
		String risultato2 = BCrypt.hashpw("prova", BCrypt.gensalt(12));
		System.out.println(risultato);
		System.out.println(risultato2);
		if(BCrypt.checkpw(password, risultato)) {
			System.out.println("Password corretta!");
		}
		else
			System.out.println("Password sbagliata!");

		Utente u2 = new Utente();
		u2.setUser("prova4");
		u2.setPassword("prova4");
		u2.setEmail("prova4@prova");
		u2.setNome("Mario");
		u2.setCognome("Rossi");
		DBManager.getInstance().utenteDAO().save(u2);
//		Utente u = new Utente();
//		u.setUser("");
//		u.setPassword("p2");
//		u.setEmail("p3");
//		u.setNome("");
//		u.setCognome("p5");
//		DBManager.getInstance().utenteDAO().update(u, u2);
//		Utente u = new Utente();
//		u.setUser("prova");
//		DBManager.getInstance().utenteDAO().delete(u);
	}
	
}
