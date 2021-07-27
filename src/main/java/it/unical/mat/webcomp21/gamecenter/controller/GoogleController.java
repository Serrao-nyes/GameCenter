package it.unical.mat.webcomp21.gamecenter.controller;

import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class GoogleController {


    @PostMapping("doLoginGoogle")
    public Boolean google(HttpSession session,@RequestParam String username, @RequestParam String email,
                         @RequestParam String nome, @RequestParam String cognome) {
        Utente utenteEmail = DBManager.getInstance().utenteDAO().findByEmail(email);
        if(utenteEmail != null) {
        	Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
            if((utente != null) && BCrypt.checkpw("", utente.getPassword())) {
               session.setAttribute("usernameloggedGoogle", username);
               session.setAttribute("nomeUtente", utente.getNome());
               return true;
        	}
            return false; 
        }
        else {
            Utente nuovoUtente = new Utente();
            nuovoUtente.setUser(username);
            nuovoUtente.setPassword("");
            nuovoUtente.setEmail(email);
            nuovoUtente.setNome(nome);
            nuovoUtente.setCognome(cognome);
            DBManager.getInstance().utenteDAO().save(nuovoUtente);
            session.setAttribute("usernameloggedGoogle", username);
            session.setAttribute("nomeUtente", nome);
            return true;
        }

    }



}
