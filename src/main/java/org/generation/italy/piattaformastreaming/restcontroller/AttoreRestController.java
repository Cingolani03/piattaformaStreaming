package org.generation.italy.piattaformastreaming.restcontroller;

import java.util.List;

import org.generation.italy.model.Attore;
import org.generation.italy.model.Contenuto;
import org.generation.italy.repository.AttoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/Attore")
public class AttoreRestController {
	@Autowired
	AttoriRepository attoriRepository;
	
	@GetMapping ("/elenco")
	public List<Attore> elencoAttori(){
		return attoriRepository.findAll();
	}
}
	

