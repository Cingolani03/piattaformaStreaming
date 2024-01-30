package org.generation.italy.repository;

import org.generation.italy.model.Regista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistaRepository extends JpaRepository<Regista,Integer>{
	
	

}
