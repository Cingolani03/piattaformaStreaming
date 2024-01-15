package org.generation.italy.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.generation.italy.model.Contenuto;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ContenutiRepository extends JpaRepository<Contenuto, Integer> {

List<Contenuto> findByTipologiaLike(String tipologia);
List<Contenuto> findByGenereLike(String genere);
List<Contenuto> findByAnno(int anno);
List<Contenuto> findByDurataLessThan(int durata);
List<Contenuto> findByTitoloIgnoreCase(String titolo);
List<Contenuto> findByTitoloIgnoreCaseAndTipologiaLike(String titolo, String tipologia);
}



