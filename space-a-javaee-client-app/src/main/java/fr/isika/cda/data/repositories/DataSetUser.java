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
public class DataSetUser {

	
	private static final Logger LOGGER = Logger.getLogger(DataSetUser.class.getName());
	
	@PersistenceContext
	private EntityManager manager;

	@PostConstruct
	private void init() {
		LOGGER.info("Début du DataSetUser");
		
		// Jeu de test
		// 1 user : test
		UserAccount acc = new UserAccount();
		acc.setUsername("Visiteur");
		acc.setPassword("123");
		acc.setPrimaryRole(UserRole.VISITOR);

		UserContact contact = new UserContact();
		UserProfile userProfile = new UserProfile()
				.withFirstName("Julie")
				.withLastName("Trappeur")
				.withContact(contact); // attached manually because of the @Embedded

		acc.setUserProfile(userProfile);

		// ajouter les cascades
		manager.persist(contact); // persisted manually because of the @Embedded
		manager.persist(acc);
		
		
	
		// User 2
		UserAccount acc2 = new UserAccount();
		acc2.setUsername("Admin");
		acc2.setPassword("123");
		acc2.setPrimaryRole(UserRole.ADMIN);

		UserContact contact2 = new UserContact();
		UserProfile userProfile2 = new UserProfile()
				.withFirstName("Alain")
				.withLastName("Taweld")
				.withContact(contact2);

		acc2.setUserProfile(userProfile2);

		// ajouter les cascades
		manager.persist(contact2);
		manager.persist(acc2);
	
		
		// User 3
		UserAccount acc3 = new UserAccount();
		acc3.setUsername("Member");
		acc3.setPassword("123");
		acc3.setPrimaryRole(UserRole.MEMBER);

		UserContact contact3 = new UserContact();
		UserProfile userProfile3 = new UserProfile()
				.withFirstName("Elsa")
				.withLastName("Asson")
				.withContact(contact3);

		acc3.setUserProfile(userProfile3);

		// ajouter les cascades
		manager.persist(contact3);
		manager.persist(acc3);
		
		
		// User 4
		UserAccount acc4 = new UserAccount();
		acc4.setUsername("User");
		acc4.setPassword("123");
		acc4.setPrimaryRole(UserRole.USER);

		UserContact contact4 = new UserContact();
		UserProfile userProfile4 = new UserProfile()
				.withFirstName("Jean-Claude")
				.withLastName("Paloin")
				.withContact(contact4);

		acc4.setUserProfile(userProfile4);

		// ajouter les cascades
		manager.persist(contact4);
		manager.persist(acc4);
		
		LOGGER.info("Fin du DataSetUser");
		
		
		
		
	}

}
