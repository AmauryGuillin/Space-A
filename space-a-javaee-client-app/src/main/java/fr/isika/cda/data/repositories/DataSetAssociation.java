package fr.isika.cda.data.repositories;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.AssociationDepiction;
import fr.isika.cda.entities.association.AssociationIdentity;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserContact;
import fr.isika.cda.entities.users.UserProfile;
import fr.isika.cda.entities.users.UserRole;

@Singleton
@Startup
public class DataSetAssociation {

	
	private static final Logger LOGGER = Logger.getLogger(DataSetAssociation.class.getName());
	
	@PersistenceContext
	private EntityManager manager;

	@PostConstruct
	private void init() {
		LOGGER.info("Début du DataSetAssoc");
		
		// Jeu de test
		// 1 assoc : test
		Association assoc = new Association();
		assoc.setLegalName("Legal name");
		assoc.setRegistrationNumber("72367826387");
		
		AssociationIdentity assocId = new AssociationIdentity();
		assocId.setHeadOffice("M. HeadOffice");
		assocId.setDirector("Ms. Director");
		assocId.setRscNumber("2132");
		
		AssociationDepiction assocDepic = new AssociationDepiction();
		assocDepic.setName("Foot Team");
		assocDepic.setMainImage("url");
		assocDepic.setLogo("url");
		assocDepic.setDescription("the best assoc");
		
		
		manager.persist(assoc);
		manager.persist(assocId);
		manager.persist(assocDepic);

		
		LOGGER.info("Fin du DataSet");
		
		
		
		
	}

}
