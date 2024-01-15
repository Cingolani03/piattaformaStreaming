package org.generation.italy.controller;

import java.util.ArrayList;
import java.util.Collections;


import org.generation.italy.model.Contenuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Contenuti")
public class contenutiController<ContenutiRepository> {
	@Autowired
	org.generation.italy.repository.ContenutiRepository contenutiRepository;
	
@GetMapping("/visione")
@ResponseBody
public String elencoContenuti(
		String ordinamento,
		@RequestParam(required=false)String titolo,
		@RequestParam(required=false)String tipologia,
		@RequestParam(required=false)String genere,
		@RequestParam(required=false)Integer anno,
        @RequestParam(required=false)Integer durata)
  				throws Exception{
	
	ArrayList<Contenuto> elencoContenuti=null;
	if(titolo==null && tipologia==null && genere==null && anno==null)
		elencoContenuti= (ArrayList<Contenuto>) contenutiRepository.findAll();
	else if( titolo!=null && tipologia!=null)
	    elencoContenuti=(ArrayList<Contenuto>) contenutiRepository.findByTitoloIgnoreCase(titolo);
	else if(genere!=null && titolo==null)
		elencoContenuti=(ArrayList<Contenuto>)contenutiRepository.findByGenereLike("%" + genere + "%");
	else if(titolo==null && genere==null && anno!=null)
		elencoContenuti=(ArrayList<Contenuto>)contenutiRepository.findByAnno(anno);
	else if(titolo==null && genere==null && durata!=null)
		elencoContenuti=(ArrayList<Contenuto>)contenutiRepository.findByDurataLessThan(durata);
	else
	    elencoContenuti=(ArrayList<Contenuto>) contenutiRepository.findByTitoloIgnoreCaseAndTipologiaLike(titolo, "&"+ tipologia);

	
	if(ordinamento!=null) {
		if(ordinamento.equals("asc"))
			Collections.sort(elencoContenuti);
		else if(ordinamento.equals("desc"))
				Collections.sort(elencoContenuti,Collections.reverseOrder());
		else 
			return "ordinamneto non valido";
		}
		StringBuilder elenco=new StringBuilder();
		elenco.append("prende le cose dal DB"+elencoContenuti.size());
        elenco.append("<br> <br>");
		for (Contenuto p:elencoContenuti)
				elenco.append(p.toString()+ "<br>");
		return elenco.toString();

}


}
