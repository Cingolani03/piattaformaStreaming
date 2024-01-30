package org.generation.italy.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Attore {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (nullable = false)
	
	private String nome;	
	private String cognome;		
	private String nazionalita;
	private LocalDate dataNascita;
	
	public Attore() {
		super();		
	}

	public Attore(LocalDate dataNascita) {
		super();
		this.dataNascita = dataNascita;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}
	
	@ManyToMany (mappedBy = "elencoAttori")
	private List<Contenuto> elencoContenuti;

	public List<Contenuto> getElencoContenuti() {
		return elencoContenuti;
	}

	public void setElencoContenuti(List<Contenuto> elencoContenuti) {
		this.elencoContenuti = elencoContenuti;
	}

	@Override
	public String toString() {
		return "Lista attori [id= " + id + "nome= "+nome+"cognome= "+cognome+"nazionalità= "+nazionalita+"data di nascita= "+dataNascita;
    }
	
}
