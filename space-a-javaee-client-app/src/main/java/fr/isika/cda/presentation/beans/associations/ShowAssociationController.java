package fr.isika.cda.presentation.beans.associations;


import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.AssociationSubscriberRepo;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.users.AssociationSubscriber;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserRole;
import fr.isika.cda.presentation.beans.associations.viewmodels.AssociationViewModel;
import fr.isika.cda.presentation.beans.users.ShowUserController;
import fr.isika.cda.presentation.beans.users.UserLoginController;

@ManagedBean
@SessionScoped
public class ShowAssociationController {

	private AssociationViewModel assoVM = new AssociationViewModel();
	
	@Inject
	private AssociationRepository assoRepo;
	
	@Inject
	private UserAccountRepository userRepo;
	
	@Inject
	private AssociationSubscriberRepo associationSubscriberRepo;

	@Inject
	private ShowUserController showUserController;
	
	@Inject
	private UserLoginController userLoginController;

	private Long assoId;
	private Long userId;
	private Association asso;
	private UserAccount userAccount;
	
	
	public List<Association> getAllAssociations(){
		return assoRepo.findAll();
	}
	
	public void getOneAssociation() {
		asso = assoRepo.findOneById(assoId);
	}
	
	public UserAccount getOneUser() {
		if (userAccount == null) {
			userId = userLoginController.displayUserId();
			userAccount = userRepo.findByOneId(userId);
		}
		return userAccount;
	}
	
	public AssociationSubscriber getOneAssoSub() {
		
		UserAccount user = getOneUser();
		UserAccount anotherUser  = userRepo.findByOneId(user.getUserId());
		
		return anotherUser.getAssociationSubscriber();
	}
	
	

	public Association attributListner(ActionEvent event) {
		asso = (Association) event.getComponent().getAttributes().get("asso");
		return asso;		
	}	
	
	private UserAccount recupUser() {
		userId = userLoginController.displayUserId();
		UserAccount user = userRepo.findByOneId(userId);
		return user;
	}
	
	public List<UserAccount> recupAllMembersOfAssoc() {
		UserAccount user = getOneUser();

		UserAccount admin = userRepo.findByOneId(user.getUserId());
		System.out.println("************************************************************admin ID : " + admin.getAssociation());

		List<Long> list = associationSubscriberRepo.listOfMemberIdOfAsso(admin.getAssociation().getId());
		
		List<UserAccount> memberList = new ArrayList<UserAccount>();
		for (Long userId : list) {
			UserAccount anotherUser = showUserController.returnOneUserById(userId);
			memberList.add(userAccount);
		}
		return memberList;
	}
	
	
	public String subscribeToAsso() {
		
		//récupérer le user 
		UserAccount userConnecte = recupUser();

		
		//récupérer l'asso clické ! 
		FacesContext fc = FacesContext.getCurrentInstance();
		
		Long cePUTAINdidAssoDeMERDE = Long.parseLong(fc.getExternalContext().getRequestParameterMap().get("assoIdjpp"));
		Association assoRecup = assoRepo.findOneById(cePUTAINdidAssoDeMERDE);
		
		
		//je modifie mon AssiociationSubscriber
		userConnecte.getAssociationSubscriber().setMembershipStatus(true);
		userConnecte.setPrimaryRole(UserRole.MEMBER);
		userConnecte.getAssociationSubscriber().setDateOfMembership(new Date());
		userConnecte.getAssociationSubscriber().addAssociationToUser(assoRecup);
		userConnecte.setSelectedAssociation(cePUTAINdidAssoDeMERDE);

				
		//j'update mon user dans la bdd
		userRepo.majProfile(userConnecte);
		
		
		
		return "/index.xhtml?faces-redirect=true";
	}
	
	
	public Boolean idAssociationComparison() {

		UserAccount user = getOneUser();
		UserAccount anotherUser  = userRepo.findByOneId(user.getUserId());

		for (Association association : anotherUser.getAssociationSubscriber().getAssociations()) {
			
			
			if (asso.getId() == association.getId()) {
				return true;
			}
		}
		return false;
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
