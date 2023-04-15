package fr.isika.cda.data.repositories;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.entities.association.subscriptions.AssoAdminSubscription;


@Singleton
@Startup
public class DataSetAssoAdminSubscription {
	
	private static final Logger LOGGER = Logger.getLogger(DataSetAssociation.class.getName());

	@PersistenceContext
	private EntityManager manager;

	@PostConstruct
	private void init() {
		LOGGER.info("Début du DataSetAssoSubsciption");

		
		// Jeu de test
		// 1 assoc : Spac'A Abonnement
		
		AssoAdminSubscription assoAS = new AssoAdminSubscription();
		assoAS.setTitle("Abonnement Spac'Ab");
		assoAS.setPrice(49.99);
		assoAS.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit."
				+ " Vivamus dignissim vulputate mauris ac consectetur."
				+ " Vivamus eget est ut enim lobortis convallis.");
		
		manager.persist(assoAS);

		LOGGER.info("Fin du DataSetAssoSubsciption");

	}

}
