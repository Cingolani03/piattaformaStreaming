
package org.generation.italy.model;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


// la classe seguente è collegata con una tab del DB 
@Entity 
public class Contenuto implements Comparable<Contenuto>{ 
	@ManyToOne(optional = false)
    private Regista regista;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //l'ID verrà autogenerato ad ogni inserimento di riga
	private int id;
	
	@Column (nullable = false, length=20)
	private String titolo;
	
	@Column (nullable=false, length=20)  // nullable serve a dire se la colonna della tabella può essere nulla
	private String tipologia;
	
	@Column (nullable=false, length=20)
	private String genere;
	
	@Column (nullable=false)
	private int anno;
	
	@Column (nullable=false )
	private int durata;
	
	public Contenuto()		//Spring ha bisogno di un costruttore vuoto perchè tramite la reflection
	//di istanziare l'oggetto senza sapere i suoi parametri prima 
{
super();
}


public Contenuto(String titolo,String tipologia, String genere , int anno, int durata)
{
super();
this.titolo=titolo;
this.genere=genere;
this.durata=durata;
this.anno=anno;
}





public Regista getRegista() {
	return regista;
}


public void setRegista(Regista regista) {
	this.regista = regista;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public List<Attore> getElencoAttori() {
	return elencoAttori;
}


public void setElencoAttori(List<Attore> elencoAttori) {
	this.elencoAttori = elencoAttori;
}


public void setTipologia(String tipologia) {
	this.tipologia = tipologia;
}


public void setGenere(String genere) {
	this.genere = genere;
}


public void setAnno(int anno) {
	this.anno = anno;
}


public void setDurata(int durata) {
	this.durata = durata;
}


public String getTitolo() {
	return titolo;
}


public void setTitolo(String titolo) {
	this.titolo = titolo;
}


public String getTipologia() {
return tipologia;
}

public String getGenere() {
return genere;
}

public int getAnno() {
	return anno;
}

public int getDurata() {
	return durata;
}

@Override
public String toString() {
return "Contenuto [nome="+titolo+", genere"+genere+",durata= "+durata+", anno="+anno+"]";
} 



@Override
public int compareTo(Contenuto c)
{
if(this.titolo.compareTo(c.getTitolo())!=0)
	return this.titolo.compareTo(c.getTitolo()); //se i nomi non sono uguali ritorna in ordine di nome
else //se i nomi sono sono uguali ordino per anno 
{
	if (this.anno>c.anno)
		return 1;
	else if	(this.anno<c.anno) 
		return -1;
	else
		return 0;
		
}
}

  @ManyToMany 
   private List<Attore> elencoAttori;
   
}