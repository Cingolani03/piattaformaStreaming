package org.generation.italy.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Tessera {

	
@Id
@GeneratedValue  
private int id;

@Column (nullable =   false)
private LocalDate dataAttivazione;
}
