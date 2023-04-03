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
		
		AssociationDepiction assocDepic = new AssociationDepiction();
		assocDepic.setName("Foot Team");
		assocDepic.setMainImage("url");
		assocDepic.setLogo("url");
		assocDepic.setDescription("the best assoc");
		
		AssociationIdentity assocId = new AssociationIdentity();
		assocId.setHeadOffice("M. HeadOffice");
		assocId.setDirector("Ms. Director");
		assocId.setRscNumber("2132");
		assocId.setAssociationDepiction(assocDepic);
		
		Association assoc = new Association();
		assoc.setLegalName("Legal name");
		assoc.setRegistrationNumber("72367826387");
		assoc.setAssociationIdentity(assocId);
		assoc.setAssociationDepiction(assocDepic);
		
		manager.persist(assoc);


		// 2e assoc
		AssociationDepiction assoc2Depic = new AssociationDepiction();
		assoc2Depic.setName("Golf Team");
		assoc2Depic.setMainImage("url");
		assoc2Depic.setLogo("url");
		assoc2Depic.setDescription("Ze best assoc");
		
		AssociationIdentity assoc2Id = new AssociationIdentity();
		assoc2Id.setHeadOffice("M. Office");
		assoc2Id.setDirector("Ms. Louise");
		assoc2Id.setRscNumber("3322");
		assoc2Id.setAssociationDepiction(assoc2Depic);
		
		Association assoc2 = new Association();
		assoc2.setLegalName("Legal name");
		assoc2.setRegistrationNumber("3773737826387");
		assoc2.setAssociationIdentity(assoc2Id);
		assoc2.setAssociationDepiction(assoc2Depic);

		manager.persist(assoc2);
		
		
		LOGGER.info("Fin du DataSetAssoc");
		
		
		
		
	}

}
