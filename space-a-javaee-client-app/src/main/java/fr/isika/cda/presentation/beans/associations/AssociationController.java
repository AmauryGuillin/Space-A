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
		return "/configSpace.xhtml?faces-redirect=true"; 
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
		assoVM.setLegalName("KakawetFrez");
		assoVM.setRegistrationNumber("552 178 639 00132");
		assoVM.setDescription("Nous sommes une petite association dédiée à la pratique du 'cacahuète fraise', un sport encore méconnu mais avec de grandes similitudes avec la pétanque. "
				+ "Le but de notre jeu est très simple. Il vous faut tirer une cacahuète au milieu du terrain de jeu. Munissez-vous de fraises et essayer de toucher la cacahuète ! "
				+ "Notre dirigeante, détient le record absolu avec 46 fraises réussies à la suite. Sauriez-vous relever le défi ?");
		assoVM.setHeadOffice("7 chemin Colette Jacquot, 46813 Merledan");
		assoVM.setRscNumber("PARIS B 517 403 572");
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
