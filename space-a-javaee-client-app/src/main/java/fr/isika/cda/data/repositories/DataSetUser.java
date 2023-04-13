package fr.isika.cda.data.repositories;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.entities.association.subscriptions.Subscription;
import fr.isika.cda.entities.common.Address;
import fr.isika.cda.entities.common.Phone;
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
		Address firstAdr = new Address();
		firstAdr.setCity("city1");
		firstAdr.setCountry("France");
		firstAdr.setLineOne("Ligne 1 de l'adresse");
		firstAdr.setLineTwo("Ligne 2 de l'adresse");
		firstAdr.setState("Region1");
		firstAdr.setZipCode("00001");
		
		Phone firstPhone = new Phone();
		firstPhone.setCounrtyCode("+33");
		firstPhone.setPhoneNumber("00 00 00 00 01");

		UserContact contact = new UserContact();
		contact.setPrimaryEmail("email1-email@email.fr");
		contact.setAddress(firstAdr);
		contact.setPhone(firstPhone);
		contact.setAddress(firstAdr);
		
		UserProfile userProfile = new UserProfile()
				.withFirstName("Julie")
				.withLastName("Trappeur")
				.withAvatar("user-avatar-basic.PNG")
				.withContact(contact); // attached manually because of the @Embedded

		UserAccount acc = new UserAccount()
				.withUsername("Visiteur")
				.withPassword("123")
				.withPrimaryRole(UserRole.VISITOR)
				.withSelectedAssociation(1L)
				.withProfile(userProfile);
	
		
		// ajouter les cascades
		manager.persist(contact); // persisted manually because of the @Embedded
		manager.persist(acc);
		
	

	
		
		// MEMBER
		Address thirdAdr = new Address();
		thirdAdr.setCity("city3");
		thirdAdr.setCountry("France");
		thirdAdr.setLineOne("Ligne 1 de l'adresse");
		thirdAdr.setLineTwo("Ligne 2 de l'adresse");
		thirdAdr.setState("Region3");
		thirdAdr.setZipCode("00003");
		
		Phone thirdPhone = new Phone();
		thirdPhone.setCounrtyCode("+33");
		thirdPhone.setPhoneNumber("00 00 00 00 03");

		UserContact contact3 = new UserContact();
		contact3.setPrimaryEmail("email3-email@email.fr");
		contact3.setAddress(thirdAdr);
		contact3.setPhone(thirdPhone);
		
		UserProfile userProfile3 = new UserProfile()
				.withFirstName("Elsa")
				.withLastName("Asson")
				.withAvatar("user-avatar-basic.PNG")
				.withContact(contact3);

		UserAccount acc3 = new UserAccount()
				.withUsername("Member")
				.withPassword("123")
				.withPrimaryRole(UserRole.MEMBER)
				.withSelectedAssociation(1L)
				.withProfile(userProfile3);

			
		// ajouter les cascades
		manager.persist(contact3);
		manager.persist(acc3);
		
		
		// USER
		Address fourthAdr = new Address();
		fourthAdr.setCity("city4");
		fourthAdr.setCountry("France");
		fourthAdr.setLineOne("Ligne 1 de l'adresse");
		fourthAdr.setLineTwo("Ligne 2 de l'adresse");
		fourthAdr.setState("Region4");
		fourthAdr.setZipCode("00004");
		
		Phone fourthPhone = new Phone();
		fourthPhone.setCounrtyCode("+33");
		fourthPhone.setPhoneNumber("00 00 00 00 04");

		UserContact fourth = new UserContact();
		fourth.setPrimaryEmail("email4-email@email.fr");
		fourth.setAddress(fourthAdr);
		fourth.setPhone(fourthPhone);
		
		UserProfile userProfile4 = new UserProfile()
				.withFirstName("Jean-Claude")
				.withLastName("Paloin")
				.withAvatar("user-avatar-basic.PNG")
				.withContact(fourth);
		
		UserAccount acc4 = new UserAccount()
				.withUsername("User")
				.withPassword("123")
				.withPrimaryRole(UserRole.USER)
				.withSelectedAssociation(1L)
				.withProfile(userProfile4);
		
	
		// ajouter les cascades
		manager.persist(fourth);
		manager.persist(acc4);
		
		LOGGER.info("Fin du DataSetUser");
		
		
		
		
	}

}
