package fr.isika.cda.data.repositories;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserContact;
import fr.isika.cda.entities.users.UserProfile;
import fr.isika.cda.entities.users.UserRole;

@Singleton
@Startup
public class DataSet {

	
	private static final Logger LOGGER = Logger.getLogger(DataSet.class.getName());
	
	@PersistenceContext
	private EntityManager manager;

	@PostConstruct
	private void init() {
		LOGGER.info("Début du DataSet");
		
		// Jeu de test
		// 1 user : test
		UserAccount acc = new UserAccount();
		acc.setUsername("test");
		acc.setPassword("123");
		acc.setPrimaryRole(UserRole.VISITOR);

		UserContact contact = new UserContact();
		UserProfile userProfile = new UserProfile()
				.withFirstName("first name")
				.withLastName("lastname")
				.withContact(contact);

		acc.setUserProfile(userProfile);

		manager.persist(contact);
		manager.persist(userProfile);
		manager.persist(acc);
		
		LOGGER.info("Fin du DataSet");
	}

}
