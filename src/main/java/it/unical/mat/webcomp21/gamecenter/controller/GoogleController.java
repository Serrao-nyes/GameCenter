package it.unical.mat.webcomp21.gamecenter.controller;

import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class GoogleController {


    @PostMapping("doGoogle")
    public Boolean google(HttpSession session,@RequestParam String username, @RequestParam String email,
                         @RequestParam String nome, @RequestParam String cognome) {
        Utente utenteEmail = DBManager.getInstance().utenteDAO().findByEmail(email);
        if (utenteEmail != null) {

                Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
                if ((utente != null) && BCrypt.checkpw("", utente.getPassword())) {
                   session.setAttribute("usernamelogged", username);
                    session.setAttribute("nomeUtente", utente.getNome());
                   return true;
                }
            return false;
            }

        else
        {
            Utente nuovoUtente = new Utente();
            nuovoUtente.setUser(username);
            nuovoUtente.setPassword("");
            nuovoUtente.setEmail(email);
            nuovoUtente.setNome(nome);
            nuovoUtente.setCognome(cognome);
            System.out.println("USER: " + username);
            System.out.println("EM: " + email);
            System.out.println("NOME: " + nome);
            System.out.println("COGNOME: " + cognome);
            DBManager.getInstance().utenteDAO().save(nuovoUtente);
            session.setAttribute("usernamelogged", username);
            session.setAttribute("nomeUtente",nome);
            return true;
        }

    }

    /*@PostMapping("doLoginGoogle")
    public Boolean login(HttpSession session, @RequestParam String username) {
        Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
        if ((utente != null) && BCrypt.checkpw("", utente.getPassword())) {
            session.setAttribute("usernamelogged", username);
            session.setAttribute("nomeUtente", utente.getNome());
            return true;
        }
        return false;
    }*/


}
