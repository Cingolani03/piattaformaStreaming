package org.generation.italy.piattaformastreaming.restcontroller;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.generation.italy.model.Contenuto;
import org.generation.italy.repository.AttoriRepository;
import org.generation.italy.repository.ContenutiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Contenuto")
public class ContenutiRestController {
	@Autowired
	ContenutiRepository contenutiRepository;

	@GetMapping("/elenco")
	public List<Contenuto> elencoContenuti(){
	
		return contenutiRepository.findAll();
	}
	@Autowired
	AttoriRepository attoriRepository;
	@PostMapping
	public Contenuto inserisciContenuto (@RequestBody Contenuto contenuto) {
		
		return contenutiRepository.save(contenuto);
}
	@PutMapping("{id}")
	public Contenuto aggiornaContenuto(@PathVariable Integer id,@RequestBody Contenuto contenuto) {
		Optional<Contenuto> result = contenutiRepository.findById(id);
		if(result.isPresent()) {
			Contenuto c=result.get();
			
			c.setGenere(contenuto.getGenere());
			c.setTitolo(contenuto.getTitolo());
			c.setAnno(contenuto.getAnno());
			c.setDurata(contenuto.getDurata());
			c.setTipologia(contenuto.getTipologia());
			
			return contenutiRepository.save(c);
			}
		else
			return null;
	}
	
	@DeleteMapping("{id}")
	public void eliminaProdotto(@PathVariable Integer id) {
		contenutiRepository.deleteById(id);
	}
}
