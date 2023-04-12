package fr.isika.cda.presentation.beans.associations;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.AssociationDepiction;
import fr.isika.cda.entities.association.AssociationIdentity;
import fr.isika.cda.entities.association.graphic.AssociationSpace;
import fr.isika.cda.entities.association.graphic.GraphicChart;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserRole;
import fr.isika.cda.presentation.beans.associations.viewmodels.AssociationViewModel;
import fr.isika.cda.presentation.beans.users.UserLoginController;
import fr.isika.cda.presentation.beans.users.viewmodels.UserViewModel;

@ManagedBean
public class AssociationController {

	private AssociationViewModel assoVM = new AssociationViewModel();
	private Long userId;
	
	//private UserViewModel userVM = new UserViewModel();
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
		userId = userLoginController.displayUserId();
		UserAccount userConnecte = userRepo.findByOneId(userId);//je récup mon user connecté
		
		userConnecte.setAssociation(asso);
		userConnecte.setPrimaryRole(UserRole.ADMIN);
		userConnecte.getAssociationSubscriber().setMembershipStatus(true);;;
		userConnecte.setSelectedAssociation(asso.getId());
			
		userRepo.updateUserFromAsso(userConnecte);

		//Reset VM
		assoVM = new AssociationViewModel(); 
		return "/configSpace.xhtml?faces-redirect=true"; //TODO 00 Demander à Mo car fullcon
	}


	private Association createAssoFromVM() {
	
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
		
		Association asso = new Association();
		asso.setRegistrationNumber(assoVM.getRegistrationNumber());
		asso.setLegalName(assoVM.getLegalName());
		asso.setAssociationIdentity(assoI);
		asso.setAssociationSpace(assoSpace);
		
		
		return asso;
	}
	
	public void autoFillPageOne() {
		assoVM.setLegalName("legal name");
		assoVM.setRegistrationNumber("000001");
//		assoVM.setName("nom");
		assoVM.setDescription("description");
//		assoVM.setLogo("Path du logo....");
//		assoVM.setMainImage("Path de l'image principale");
		assoVM.setHeadOffice("Siège social");
		assoVM.setRscNumber("000000001");
		assoVM.setKbisExtract("000000006545");
		assoVM.setDirector("Directeur");
	}
	


	public AssociationViewModel getAssoVM() {
		return assoVM;
	}

	public void setAssoVM(AssociationViewModel assoVM) {
		this.assoVM = assoVM;
	}

	public AssociationRepository getAssoRepo() {
		return assoRepo;
	}

	public void setAssoRepo(AssociationRepository assoRepo) {
		this.assoRepo = assoRepo;
	}

	@Override
	public String toString() {
		return "AssociationController [assoVM=" + assoVM + ", assoRepo=" + assoRepo + "]";
	}
	
	
}
