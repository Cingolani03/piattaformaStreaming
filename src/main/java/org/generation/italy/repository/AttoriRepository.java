package org.generation.italy.repository;

import org.generation.italy.model.Attore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttoriRepository extends JpaRepository<Attore, Integer> {

}
