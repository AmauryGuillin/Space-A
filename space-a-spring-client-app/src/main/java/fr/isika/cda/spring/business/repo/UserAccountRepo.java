package fr.isika.cda.spring.business.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.isika.cda.entities.users.UserAccount;

@Repository
public interface UserAccountRepo extends CrudRepository<UserAccount, Long> {
	
	//----> Possible rajout de méthodes custom ICI <----
	
}