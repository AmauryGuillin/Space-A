package fr.isika.cda.presentation.beans.associations;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;


import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.AssociationDepiction;
import fr.isika.cda.entities.association.AssociationIdentity;
import fr.isika.cda.entities.association.functionnality.AssociationFunctionnality;
import fr.isika.cda.entities.association.functionnality.ConfigType;
import fr.isika.cda.entities.association.graphic.AssociationSpace;
import fr.isika.cda.entities.association.graphic.GraphicChart;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserRole;
import fr.isika.cda.presentation.beans.associations.viewmodels.AssociationViewModel;
import fr.isika.cda.presentation.beans.users.UserLoginController;

@ManagedBean
@ViewScoped
public class AssociationController {

	
	private AssociationViewModel assoVM = new AssociationViewModel();

	@Inject
	private UserLoginController userLoginController;
	
	@Inject
	private AssociationRepository assoRepo;
	
	@Inject 
	private UserAccountRepository userRepo;
	

	public String CreateAsso() {
		
		//TODO ABI faire le control : si co ok sinon page login
		
		//Creation Asso
		Association asso = createAssoFromVM();
		
		//asso créé en bdd
		assoRepo.createAsso(asso);
		
		//rattaché le userAccount à l'asso créé
		Long userId = userLoginController.displayUserId();
		UserAccount userConnecte = userRepo.findByOneId(userId);
		userConnecte.updateSelectedAssociation(asso.getId());

		// Ecraser la variable a chaque appel pour màj avec le builder 
		userConnecte = userConnecte.withAssociation(asso);
		userConnecte = userConnecte.withPrimaryRole(UserRole.ADMIN);
		
		userRepo.updateUserFromAsso(userConnecte);

		//Reset VM
		assoVM = new AssociationViewModel();
		//TODO 00 Demander à Mo car fullcon
		return "/subscriptionDisplayPage.xhtml?faces-redirect=true"; 
	}

	private Association createAssoFromVM() {
	
		//ConfigType Association Default
//		PublicationType publiDefault = new PublicationType();
//		publiDefault.setNamePublicationType("Article");
//		ActivityType activityDefault = new ActivityType();
//		activityDefault.setNameActivityType("Entrainement");
//		RentingType rentingDefault = new RentingType();
//		rentingDefault.setNameRentingType("Salle");
		
		
		//Graphic Association Default
		GraphicChart assoGraphic = new GraphicChart();
//		assoGraphic.setBanner("Je suis une belle banière");//
		assoGraphic.setFont("Police par defaut"); //TODO ABI Font pour Asso !
		assoGraphic.setMainColor("FFFFFF");
		assoGraphic.setSecondaryColor("132d64");
		assoGraphic.setTertiaryColor("000000");
		
		AssociationSpace assoSpace = new AssociationSpace();
		assoSpace.setGraphicChart(assoGraphic);
		
		AssociationDepiction assoD = new AssociationDepiction();
		assoD.setDescription(assoVM.getDescription());
		assoD.setLogo("logo-basic.PNG");
		assoD.setName(assoVM.getLegalName());
		assoD.setMainImage("main-image-basic.jpg");
		
		AssociationIdentity assoI = new AssociationIdentity();
		assoI.setDirector(assoVM.getDirector());
		assoI.setHeadOffice(assoVM.getHeadOffice());
		assoI.setKbisExtract(assoVM.getKbisExtract());
		assoI.setRscNumber(assoVM.getRscNumber());
		assoI.setAssociationDepiction(assoD);
		
		ConfigType configType = new ConfigType();
//		configType.addActivityType(activityDefault);
//		configType.addPublicationsType(publiDefault);
//		configType.addRentingType(rentingDefault);
//		
		AssociationFunctionnality assoFunction = new AssociationFunctionnality();
		assoFunction.setConfigType(configType);
		
		Association asso = new Association();
		asso.setRegistrationNumber(assoVM.getRegistrationNumber());
		asso.setLegalName(assoVM.getLegalName());
		asso.setAssociationIdentity(assoI);
		asso.setAssociationSpace(assoSpace);
		asso.setAssociationFunctionnality(assoFunction);
		
		return asso;
	}
	
	public void autoFillPageOne() {
		assoVM.setLegalName("L'Empire Noir");
		assoVM.setRegistrationNumber("552 178 639 00132");
		assoVM.setDescription("\"La paix est un mensonge, il n'y a que la passion.\r\n"
				+ "Par la passion, j'ai la puissance.\r\n"
				+ "Par la puissance, j'ai le pouvoir.\r\n"
				+ "Par le pouvoir, j'ai la victoire.\r\n"
				+ "Par la victoire, je brise mes chaines.\r\n"
				+ "La Force me libérera. \"\r\n"
				+ "Si ces mots vous parle au plus profond de vous, vous savez que le coté obscure de la force est le seul chemin possible pour accéder à l'équilibre ultime dans cette galaxie. \r\n"
				+ "Les Jedi suivent un code d'éthique qui leur impose de respecter la vie, de défendre les innocents et de se battre pour la justice. Mais \"Il n'y a pas de paix, il y a la colère.\r\n"
				+ "Il n'y a pas de peur, il y a le pouvoir.\r\n"
				+ "Il n'y a pas de mort, il y a l' immortalité.\r\n"
				+ "Il n'y a pas de faiblesse, il y a le Côté Obscur. Je suis le cœur de l'Obscurité.\r\n"
				+ "Je ne connais pas la peur mais je l'instille à mes ennemis.\r\n"
				+ "Je suis le destructeur de ce monde.\r\n"
				+ "Je connais le pouvoir du Côté Obscur.\r\n"
				+ "Je suis le feu de la haine.\r\n"
				+ "Tout l'univers se prosterne devant moi.\r\n"
				+ "Je m'engage dans l'Obscurité où j'ai découvert la vraie vie,\r\n"
				+ "Dans la Mort de la Lumière. \"");
		assoVM.setHeadOffice("7 Avenue des Sénateurs CORUSCANT 72 802");
		assoVM.setRscNumber("TATOUINE B 517 403 572");
		assoVM.setKbisExtract("Path de l'extrait kbis...");
		assoVM.setDirector("Mme. Brigitte");
	}
	
	public AssociationViewModel getAssoVM() {
		return assoVM;
	}

	public void setAssoVM(AssociationViewModel assoVM) {
		this.assoVM = assoVM;
	}

}
