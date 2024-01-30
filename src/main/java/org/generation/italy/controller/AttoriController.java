package org.generation.italy.controller;

import java.util.List;

import org.generation.italy.model.Attore;
import org.generation.italy.model.Contenuto;
import org.generation.italy.repository.AttoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Attore")

public class AttoriController {
	@Autowired
	private AttoriRepository attoriRepository;
	
	@GetMapping("/elenco")
	@ResponseBody
	public String elencoAttori() {
		List<Attore> elencoAtt=attoriRepository.findAll();		
		
		StringBuilder elenco=new StringBuilder();
		elenco.append("Numero ordini: "+ elencoAtt.size());
		elenco.append("<br><br>");
		for(Attore a:elencoAtt) {
			elenco.append(a.toString()+"<br>");
			elenco.append("---Attori:<br>");
			for (Contenuto c: a.getElencoContenuti())
				elenco.append("---"+a.toString()+"<br>");
		}
		return elenco.toString();
	}

}
