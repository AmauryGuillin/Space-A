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
		assoAS.setDescription("Cet abonnement vous permet de créer votre propre espace pour votre association"
				+ "mais aussi de le personnaliser ! Vous pourrez sélectionnez vos propres couleurs,"
				+ " logo et image d'accueil en plus de pouvoir créer vos propres 'types' pour vos publications, et matériel."
				+ " Grâce à votre dashboard administrateur vous pourrez en un seul clic gérer vos adhérents ainsi que toutes "
				+ " vos publications et matériel que vous souhaiterez mettre à disposition de vos adhérents.");
		
		manager.persist(assoAS);

		LOGGER.info("Fin du DataSetAssoSubsciption");

	}

}
