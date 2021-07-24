package it.unical.mat.webcomp21.model;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Password {
	
	public static String encrypt(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}
	
	public static Boolean check(String passwordInserita, String passwordDB) {
		return BCrypt.checkpw(passwordInserita, passwordDB);
	}

}
