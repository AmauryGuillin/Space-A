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
import fr.isika.cda.presentation.beans.users.viewmodels.UserViewModel;

@ManagedBean
public class AssociationController {

	private AssociationViewModel assoVM = new AssociationViewModel();
	
	private UserViewModel userVM = new UserViewModel();
	
	@Inject
	private AssociationRepository assoRepo;
	
	@Inject 
	private UserAccountRepository userRepo;
	
	public String CreateAsso() {
		
		//Up User to Admin
		UserAccount user = upUserToAdmin();
		userRepo.upToAdmin(user);
		
		//Creation Asso
		Association asso = createAssoFromVM();
		assoRepo.createAsso(asso);
		assoVM = new AssociationViewModel(); //Reset VM
		return "/index.xhtml?faces-redirect=true"; //TODO 00 Demander à Mo car fullcon
	}

	private UserAccount upUserToAdmin() {
		// TODO ABI faire la méthode upUser dans controller asso
		//Recupérer l'id dans les cookies pour modifier l'user en question
		
		return null;

	}

	private Association createAssoFromVM() {
		
		//Creation Manager
		
		
		//Creation Asso
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
