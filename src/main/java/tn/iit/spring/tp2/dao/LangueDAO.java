package tn.iit.spring.tp2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import tn.iit.spring.tp2.entites.Langue;

@RepositoryRestResource(path = "lang")
@Repository
public interface  LangueDAO extends JpaRepository<Langue, Long> { 
	
	Langue findByNom(String nom);
	Langue findByNomAndAbreviation(String nom,String abreviaion);
	//Langue findByNomAndX(String nom,String x);
}
