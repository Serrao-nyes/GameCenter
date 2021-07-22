package it.unical.mat.webcomp21.gamecenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaginaGiocoController {
	
	@GetMapping("GamePage")
	public String paginaGioco(Model model, @RequestParam long idGioco) {
		model.addAttribute("idGioco", idGioco);
		return "GamePage";
	}

}
