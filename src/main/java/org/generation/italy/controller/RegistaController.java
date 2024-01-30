package org.generation.italy.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.model.Contenuto;
import org.generation.italy.model.Regista;
import org.generation.italy.repository.RegistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/Registi")

public class RegistaController {
	
	@Autowired
	RegistaRepository registaRepository;
	
	@GetMapping ("/elenco")
	@ResponseBody
	public String elencoContenuti() {
		List<Regista> elencoRegisti=registaRepository.findAll();
		StringBuilder elenco=new StringBuilder();
		elenco.append("Numero Regista: " + elencoRegisti.size());
		elenco.append("<br><br>");
		for (Regista f:elencoRegisti) {
			elenco.append(f.toString()+"<br>");
		}    
		return elencoRegisti.toString();
	}
	
	@GetMapping("{id}")
	@ResponseBody
	public String dettaglioRegisti(@PathVariable Integer id) {
		Optional<Regista> optRegista=registaRepository.findById(id);
		if (optRegista.isPresent())		//il prodotto è stato trovato
		{
			StringBuilder dettaglio=new StringBuilder();
			dettaglio.append(optRegista.get().toString()+"<br>");
			dettaglio.append("Prodotti forniti: <br>");
			for (Contenuto c: optRegista.get().getElencoContenuti())
				dettaglio.append(c.toString()+"<br>");
			return dettaglio.toString();
		}			
		else
			return "Fornitore non trovato!";
	
	}
}