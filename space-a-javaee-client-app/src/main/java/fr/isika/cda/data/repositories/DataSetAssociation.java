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
import fr.isika.cda.entities.association.functionnality.ActivityType;
import fr.isika.cda.entities.association.functionnality.AssociationFunctionnality;
import fr.isika.cda.entities.association.functionnality.ConfigType;
import fr.isika.cda.entities.association.functionnality.EventType;
import fr.isika.cda.entities.association.functionnality.PublicationType;
import fr.isika.cda.entities.association.functionnality.RentingType;
import fr.isika.cda.entities.association.graphic.AssociationSpace;
import fr.isika.cda.entities.association.graphic.GraphicChart;

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
		// 1 assoc : Spac'A

		EventType eventOne = new EventType();
		eventOne.setNameEventType("Réunion");
		PublicationType publiOne = new PublicationType();
		publiOne.setNamePublicationType("Article");
		ActivityType activityOne = new ActivityType();
		activityOne.setNameActivityType("Entrainement");
		RentingType rentingOne = new RentingType();
		rentingOne.setNameRentingType("Salle");
		
		AssociationDepiction spaceDepic = new AssociationDepiction();
		spaceDepic.setName("Spac'A");
		spaceDepic.setMainImage("main-image-spacA.JPG");
		spaceDepic.setLogo("logo-basic-spaca.png");
		spaceDepic.setDescription(
				"Vous savez, moi je ne crois pas qu’il y ait de bonne ou de mauvaise association. Moi, si je devais résumer ma vie aujourd’hui avec vous, je dirais que c’est d’abord des rencontres. Des gens qui m’ont tendu la main, peut-être à un moment où je ne pouvais pas, où j’étais seul chez moi. Et c’est assez curieux de se dire que les hasards, les rencontres forgent une destinée… Parce que quand on a le goût de la chose, quand on a le goût de la chose bien faite, le beau geste, parfois on ne trouve pas l’interlocuteur en face je dirais, le miroir qui vous aide à avancer. Alors ça n’est pas mon cas, comme je disais là, puisque moi au contraire, j’ai pu : et je dis merci à la vie, je lui dis merci, je chante la vie, je danse la vie… je ne suis qu’amour ! Et finalement, quand beaucoup de gens aujourd’hui me disent « Mais comment fais-tu pour avoir cette humanité ? », et bien je leur réponds très simplement, je leur dis que c’est ce goût de l’amour ce goût donc qui m’a poussé aujourd’hui à entreprendre une construction mécanique, mais demain qui sait ? Peut-être simplement à me mettre au service de la communauté, à faire le don, le don de soi…");

		AssociationIdentity spaceAssocId = new AssociationIdentity();
		spaceAssocId.setHeadOffice("1-23-14, Kamikerechi, Fujiyoshida-shi, Yamashida-ken 403-0001, Japan");
		spaceAssocId.setDirector("Abigaël Castillo");
		spaceAssocId.setRscNumber("6969696969");
		spaceAssocId.setKbisExtract("extrait KBIS à mettre");
		spaceAssocId.setAssociationDepiction(spaceDepic);

		GraphicChart spaceGraphicChart = new GraphicChart();
		spaceGraphicChart.setMainColor("FFFFFF"); // blanc
		spaceGraphicChart.setSecondaryColor("132d64ad"); // bleu
		spaceGraphicChart.setTertiaryColor("000000"); // noir
		spaceGraphicChart.setFont("jsp");

		AssociationSpace spaceAssociationSpace = new AssociationSpace();
		spaceAssociationSpace.setGraphicChart(spaceGraphicChart);

		ConfigType configTypespacA = new ConfigType();
		configTypespacA.addEventType(eventOne);
		configTypespacA.addPublicationsType(publiOne);
		configTypespacA.addActivityType(activityOne);
		configTypespacA.addRentingType(rentingOne);


		AssociationFunctionnality assoFunctionspacA = new AssociationFunctionnality();
		assoFunctionspacA.setConfigType(configTypespacA);

		Association spaca = new Association();
		spaca.setLegalName("SAS - Spac'A");
		spaca.setRegistrationNumber("069 690 690 69690");
		spaca.setAssociationIdentity(spaceAssocId);
		spaca.setAssociationSpace(spaceAssociationSpace);
		spaca.setAssociationFunctionnality(assoFunctionspacA);

		manager.persist(spaca);

		// 2e asso
		// ISIKA
		
		EventType eventTwo = new EventType();
		eventTwo.setNameEventType("Réunion");
		PublicationType publiTwo = new PublicationType();
		publiTwo.setNamePublicationType("Article");
		ActivityType activityTwo = new ActivityType();
		activityTwo.setNameActivityType("Entrainement");
		RentingType rentingTwo = new RentingType();
		rentingTwo.setNameRentingType("Salle");

		AssociationDepiction assocDepic = new AssociationDepiction();
		assocDepic.setName("KakawetFrez");
		assocDepic.setMainImage("main-image-isika.png");
		assocDepic.setLogo("logo-isika.png");
		assocDepic.setDescription(
				"Vous savez, moi je ne crois pas qu’il y ait de bonne ou de mauvaise association. Moi, si je devais résumer ma vie aujourd’hui avec vous, je dirais que c’est d’abord des rencontres. Des gens qui m’ont tendu la main, peut-être à un moment où je ne pouvais pas, où j’étais seul chez moi. Et c’est assez curieux de se dire que les hasards, les rencontres forgent une destinée… Parce que quand on a le goût de la chose, quand on a le goût de la chose bien faite, le beau geste, parfois on ne trouve pas l’interlocuteur en face je dirais, le miroir qui vous aide à avancer. Alors ça n’est pas mon cas, comme je disais là, puisque moi au contraire, j’ai pu : et je dis merci à la vie, je lui dis merci, je chante la vie, je danse la vie… je ne suis qu’amour ! Et finalement, quand beaucoup de gens aujourd’hui me disent « Mais comment fais-tu pour avoir cette humanité ? », et bien je leur réponds très simplement, je leur dis que c’est ce goût de l’amour ce goût donc qui m’a poussé aujourd’hui à entreprendre une construction mécanique, mais demain qui sait ? Peut-être simplement à me mettre au service de la communauté, à faire le don, le don de soi…");

		AssociationIdentity assocId = new AssociationIdentity();
		assocId.setHeadOffice("3 Rue Danton 1er étage, 92240 Malakoff");
		assocId.setDirector("Patrick Rakotomalala");
		assocId.setRscNumber("41649649");
		assocId.setKbisExtract("extrait à mettre");
		assocId.setAssociationDepiction(assocDepic);

		GraphicChart graphicChart = new GraphicChart();
		graphicChart.setMainColor("ffffff"); // blanc
		graphicChart.setSecondaryColor("00ff08"); // vert
		graphicChart.setTertiaryColor("ff0000"); // rouge
		graphicChart.setFont("Algerian");

		AssociationSpace associationSpace = new AssociationSpace();
		associationSpace.setGraphicChart(graphicChart);
		
		ConfigType configTypkakawet = new ConfigType();
		configTypkakawet.addEventType(eventTwo);
		configTypkakawet.addPublicationsType(publiTwo);
		configTypkakawet.addActivityType(activityTwo);
		configTypkakawet.addRentingType(rentingTwo);

		AssociationFunctionnality assoFunctionkakawet = new AssociationFunctionnality();
		assoFunctionkakawet.setConfigType(configTypkakawet);

		Association assoc = new Association();
		assoc.setLegalName("ISIKA");
		assoc.setRegistrationNumber("835 200 361 00011");
		assoc.setAssociationIdentity(assocId);
		assoc.setAssociationSpace(associationSpace);
		assoc.setAssociationFunctionnality(assoFunctionkakawet);

		manager.persist(assoc);

		// 3e assoc
		
		EventType eventThree = new EventType();
		eventThree.setNameEventType("Réunion");
		PublicationType publiThree = new PublicationType();
		publiThree.setNamePublicationType("Article");
		ActivityType activityThree = new ActivityType();
		activityThree.setNameActivityType("Entrainement");
		RentingType rentingThree = new RentingType();
		rentingThree.setNameRentingType("Salle");
		
		AssociationDepiction assoc2Depic = new AssociationDepiction();
		assoc2Depic.setName("Foot en Coeur");
		assoc2Depic.setMainImage("mainImageAssoEx.jpg");
		assoc2Depic.setLogo("logoAutreAsso.jpg");
		assoc2Depic.setDescription("Ze best assoc");

		AssociationIdentity assoc2Id = new AssociationIdentity();
		assoc2Id.setHeadOffice("quelque part");
		assoc2Id.setDirector("Ms. Louise");
		assoc2Id.setRscNumber("3322");
		assoc2Id.setAssociationDepiction(assoc2Depic);

		GraphicChart graphickakawet = new GraphicChart();
		graphickakawet.setMainColor("ffffff"); // blanc
		graphickakawet.setSecondaryColor("00ff08"); // vert
		graphickakawet.setTertiaryColor("ff0000"); // rouge
		graphickakawet.setFont("Algerian");

		AssociationSpace associationSpacekakawete = new AssociationSpace();
		associationSpacekakawete.setGraphicChart(graphickakawet);
		
		ConfigType configTypjsp = new ConfigType();
		configTypjsp.addEventType(eventThree);
		configTypjsp.addPublicationsType(publiThree);
		configTypjsp.addActivityType(activityThree);
		configTypjsp.addRentingType(rentingThree);

		AssociationFunctionnality assoFunctionjsp = new AssociationFunctionnality();
		assoFunctionjsp.setConfigType(configTypjsp);


		Association assoc2 = new Association();
		assoc2.setLegalName("Legal name Foot");
		assoc2.setRegistrationNumber("3773737");
		assoc2.setAssociationIdentity(assoc2Id);
		assoc2.setAssociationSpace(associationSpacekakawete);
		assoc2.setAssociationFunctionnality(assoFunctionjsp);

		manager.persist(assoc2);

		LOGGER.info("Fin du DataSetAssoc");

	}

}
