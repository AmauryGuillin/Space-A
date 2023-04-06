package fr.isika.cda.presentation.beans.associations;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.AssociationDepiction;
import fr.isika.cda.entities.association.AssociationIdentity;
import fr.isika.cda.entities.users.UserAccount;
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
		
		//Creation Asso
		Association asso = createAssoFromVM();
		
		//asso créé en bdd
		assoRepo.createAsso(asso);
		
		//rattaché le userAccount à l'asso créé
		userId = userLoginController.displayUserId();
		UserAccount userConnecte = userRepo.findByOneId(userId);//je récup mon user connecté
		
		userConnecte.setAssociation(asso);
		
		System.out.println("----------------JE SUIS DANS CREATE ASSO POUR RATACHE MON USER--------------");
		
		userRepo.updateUserFromAsso(userConnecte);
		
		
		
		//Reset VM
		assoVM = new AssociationViewModel(); 
		return "/index.xhtml?faces-redirect=true"; //TODO 00 Demander à Mo car fullcon
	}


	private Association createAssoFromVM() {
		
		AssociationDepiction assoD = new AssociationDepiction();
		assoD.setDescription(assoVM.getDescription());
		assoD.setLogo(assoVM.getLogo());
		assoD.setName(assoVM.getName());
		assoD.setMainImage(assoVM.getMainImage());
		
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
		
		
		return asso;
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
