package fr.isika.cda.presentation.beans.associations;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.users.AssociationSubscriber;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.beans.associations.viewmodels.AssociationViewModel;
import fr.isika.cda.presentation.beans.users.UserLoginController;

@ManagedBean
public class ShowAssociationController {

	private AssociationViewModel assoVM = new AssociationViewModel();
	
	@Inject
	private AssociationRepository assoRepo;
	
	@Inject
	private UserAccountRepository userRepo;
	
	@Inject
	private UserLoginController userLoginController;

	private Long assoId;
	private Long userId;
	private Association asso;
	private Association voila;
	
	
	public List<Association> getAllAssociations(){
		return assoRepo.findAll();
	}
	
	public void getOneAssociation() {
		asso = assoRepo.findOneById(assoId);
	}
	
	
	public Association attributListner(ActionEvent event) {
		asso = (Association) event.getComponent().getAttributes().get("asso");
		return asso;
	}	
	
	//TODO j'arrive pas à récupérer l'asso de tout maniere
	public String subscribeToAsso() {
		
		//récupérer le user 
		userId = userLoginController.displayUserId();
		UserAccount userConnecte = userRepo.findByOneId(userId);

		
		//récupérer l'asso clické ! 
		FacesContext fc = FacesContext.getCurrentInstance();
		
		Long cePUTAINdidAssoDeMERDE = Long.parseLong(fc.getExternalContext().getRequestParameterMap().get("assoIdjpp"));
		Association assoRecup = assoRepo.findOneById(cePUTAINdidAssoDeMERDE);

		
		//je modifie mon AssiociationSubscriber
		userConnecte.getAssociationSubscriber().setMembershipStatus(true);
		userConnecte.getAssociationSubscriber().addAssociationToUser(assoRecup);

				
		//j'update mon user dans la bdd
		userRepo.majProfile(userConnecte);
		
		
		
		return "/index.xhtml?faces-redirect=true";
	}



	public AssociationRepository getAssoRepo() {
		return assoRepo;
	}

	public void setAssoRepo(AssociationRepository assoRepo) {
		this.assoRepo = assoRepo;
	}

	public Association getAsso() {
		return asso;
	}

	public void setAsso(Association asso) {
		this.asso = asso;
	}

	public Long getAssoId() {
		return assoId;
	}
	

	

	
	
	
	
	
	
	
	
}
