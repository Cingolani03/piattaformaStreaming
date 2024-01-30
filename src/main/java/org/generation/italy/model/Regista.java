package org.generation.italy.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Regista {
	
@OneToMany (mappedBy = "regista")
List<Contenuto> elencoContenuti;

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int id;
@Column (nullable = false, length=20)
private String nome;
@Column (nullable = false, length=20)
private String cognome;
@Column (nullable = false, length=20)
private String nazionalita;


public List<Contenuto> getElencoContenuti() {
	return elencoContenuti;
}
public int getId() {
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


@Override
public String toString() {
	return "Regista [elencoContenuti=" + elencoContenuti + ", id=" + id + ", nome=" + nome + ", cognome=" + cognome
			+ ", nazionalita=" + nazionalita + "]";
}



}