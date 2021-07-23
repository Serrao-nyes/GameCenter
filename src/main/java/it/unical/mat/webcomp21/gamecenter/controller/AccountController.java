package it.unical.mat.webcomp21.gamecenter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.unical.mat.webcomp21.model.GiocoDesiderato;
import it.unical.mat.webcomp21.model.GiocoPosseduto;
import it.unical.mat.webcomp21.model.Utente;
import it.unical.mat.webcomp21.persistence.DBManager;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {

	@GetMapping("doAccount")
	public String account(HttpSession session, Model model) {
		String username = session.getAttribute("usernamelogged").toString();
		Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
		DBManager.getInstance().utenteDAO().giochiDesiderati(utente);
		DBManager.getInstance().utenteDAO().giochiPosseduti(utente);
		if(utente.getGiochiDesiderati().size() > 0)
			model.addAttribute("giochiDesiderati", utente.getGiochiDesiderati());
		if(utente.getGiochiPosseduti().size() > 0)
			model.addAttribute("giochiPosseduti", utente.getGiochiPosseduti());
		return "Account";
	}
	
}
	
//	@GetMapping("doGiochiDesideratiSalvati")
//	public String giochiDesideratiSalvati(HttpSession session, Model model) {
//		String username = session.getAttribute("usernamelogged").toString();
//		Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
//		DBManager.getInstance().utenteDAO().giochiDesiderati(utente);
//		if(utente.getGiochiDesiderati().size() > 0)
//			model.addAttribute("giochiDesiderati", utente.getGiochiDesiderati());
//		return "Account";
//		}
//			List<Long> idGiochiDesiderati = new ArrayList<Long>();
//			for(GiocoDesiderato gd: utente.getGiochiDesiderati())
//			idGiochiDesiderati.add(gd.getId());
//			return idGiochiDesiderati;
//		}
//		//return null;
		
	
	
//	@GetMapping("doGiochiPossedutiSalvati")
//	public String giochiPossedutiSalvati(HttpSession session, Model model) {
//		String username = session.getAttribute("usernamelogged").toString();
//		Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey(username);
//		DBManager.getInstance().utenteDAO().giochiPosseduti(utente);
//		if(utente.getGiochiPosseduti().size() > 0) 
//			model.addAttribute("giochiPosseduti", utente.getGiochiPosseduti());
//		return "Account";
//			List<Long> idGiochiPosseduti = new ArrayList<Long>();
//			for(GiocoPosseduto gd: utente.getGiochiPosseduti())
//				idGiochiPosseduti.add(gd.getId());
//			return idGiochiPosseduti;
//		}
//		return null;
	
	



	/*@GetMapping("account")
	public String acc()
	{return  "Account";}*/


