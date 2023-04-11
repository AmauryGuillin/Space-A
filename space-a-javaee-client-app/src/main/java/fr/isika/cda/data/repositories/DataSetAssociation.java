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
import fr.isika.cda.entities.association.graphic.AssociationSpace;
import fr.isika.cda.entities.association.graphic.GraphicChart;
import fr.isika.cda.entities.common.Address;
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
		// 1 assoc : Spac'A
		
		AssociationDepiction spaceDepic = new AssociationDepiction();
		spaceDepic.setName("Spac'A");
		spaceDepic.setMainImage("main-image-spacA.JPG");
		spaceDepic.setLogo("logo-basic.PNG");
		spaceDepic.setDescription("Vous savez, moi je ne crois pas qu’il y ait de bonne ou de mauvaise association. Moi, si je devais résumer ma vie aujourd’hui avec vous, je dirais que c’est d’abord des rencontres. Des gens qui m’ont tendu la main, peut-être à un moment où je ne pouvais pas, où j’étais seul chez moi. Et c’est assez curieux de se dire que les hasards, les rencontres forgent une destinée… Parce que quand on a le goût de la chose, quand on a le goût de la chose bien faite, le beau geste, parfois on ne trouve pas l’interlocuteur en face je dirais, le miroir qui vous aide à avancer. Alors ça n’est pas mon cas, comme je disais là, puisque moi au contraire, j’ai pu : et je dis merci à la vie, je lui dis merci, je chante la vie, je danse la vie… je ne suis qu’amour ! Et finalement, quand beaucoup de gens aujourd’hui me disent « Mais comment fais-tu pour avoir cette humanité ? », et bien je leur réponds très simplement, je leur dis que c’est ce goût de l’amour ce goût donc qui m’a poussé aujourd’hui à entreprendre une construction mécanique, mais demain qui sait ? Peut-être simplement à me mettre au service de la communauté, à faire le don, le don de soi…");
		
		AssociationIdentity spaceAssocId = new AssociationIdentity();
		spaceAssocId.setHeadOffice("1-23-14, Kamikerechi, Fujiyoshida-shi, Yamashida-ken 403-0001, Japan");
		spaceAssocId.setDirector("Abigaël Castillo");
		spaceAssocId.setRscNumber("6969696969");
		spaceAssocId.setKbisExtract("extrait KBIS à mettre");
		spaceAssocId.setAssociationDepiction(spaceDepic);
		
		GraphicChart spaceGraphicChart = new GraphicChart();
		spaceGraphicChart.setMainColor("abaaaa"); // blanc
		spaceGraphicChart.setSecondaryColor("132d64ad"); // bleu
		spaceGraphicChart.setTertiaryColor("000000"); // noir
		spaceGraphicChart.setFont("Police à faire");
		
		AssociationSpace spaceAssociationSpace = new AssociationSpace();
		spaceAssociationSpace.setGraphicChart(spaceGraphicChart);
		
		Association spaca = new Association();
		spaca.setLegalName("Spac'A");
		spaca.setRegistrationNumber("069 690 690 69690");
		spaca.setAssociationIdentity(spaceAssocId);
		spaca.setAssociationSpace(spaceAssociationSpace);
		
		manager.persist(spaca);
		
		
		// 2e asso
		// ISIKA
		
		AssociationDepiction assocDepic = new AssociationDepiction();
		assocDepic.setName("ISIKA");
		assocDepic.setMainImage("main-image-isika.png");
		assocDepic.setLogo("logo-isika.png");
		assocDepic.setDescription("Vous savez, moi je ne crois pas qu’il y ait de bonne ou de mauvaise association. Moi, si je devais résumer ma vie aujourd’hui avec vous, je dirais que c’est d’abord des rencontres. Des gens qui m’ont tendu la main, peut-être à un moment où je ne pouvais pas, où j’étais seul chez moi. Et c’est assez curieux de se dire que les hasards, les rencontres forgent une destinée… Parce que quand on a le goût de la chose, quand on a le goût de la chose bien faite, le beau geste, parfois on ne trouve pas l’interlocuteur en face je dirais, le miroir qui vous aide à avancer. Alors ça n’est pas mon cas, comme je disais là, puisque moi au contraire, j’ai pu : et je dis merci à la vie, je lui dis merci, je chante la vie, je danse la vie… je ne suis qu’amour ! Et finalement, quand beaucoup de gens aujourd’hui me disent « Mais comment fais-tu pour avoir cette humanité ? », et bien je leur réponds très simplement, je leur dis que c’est ce goût de l’amour ce goût donc qui m’a poussé aujourd’hui à entreprendre une construction mécanique, mais demain qui sait ? Peut-être simplement à me mettre au service de la communauté, à faire le don, le don de soi…");
		
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
		graphicChart.setFont("Font à faire");
		
		AssociationSpace associationSpace = new AssociationSpace();
		associationSpace.setGraphicChart(graphicChart);
		
		Association assoc = new Association();
		assoc.setLegalName("ISIKA-(lg)");
		assoc.setRegistrationNumber("835 200 361 00011");
		assoc.setAssociationIdentity(assocId);
		assoc.setAssociationSpace(associationSpace);
		
		manager.persist(assoc);


		// 3e assoc
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
		assoc2.setLegalName("Legal name2");
		assoc2.setRegistrationNumber("3773737");
		assoc2.setAssociationIdentity(assoc2Id);

		manager.persist(assoc2);
		
		
		LOGGER.info("Fin du DataSetAssoc");
		
		
		
		
	}

}
