package fr.isika.cda.spring.business.repo;

import org.springframework.data.repository.CrudRepository;

import fr.isika.cda.entities.association.Association;

public interface AssociationSpaceRepo extends CrudRepository<Association, Long>{
	
	//----> Possible rajout de méthodes custom ICI <----

}
