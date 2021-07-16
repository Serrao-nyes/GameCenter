package it.unical.mat.webcomp21.gamecenter;

import org.springframework.security.crypto.bcrypt.BCrypt;

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
	}
	
}
