package fr.isika.cda.presentation.beans.associations;


import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.SubscriptionsRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.subscriptions.Subscription;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserRole;
import fr.isika.cda.presentation.utils.SessionUtils;

@ManagedBean
@SessionScoped
public class ShowAssociationController {
	
	@Inject
	private AssociationRepository assoRepo;
	
	@Inject
	private UserAccountRepository userRepo;
	
	@Inject
	private SubscriptionsRepository subscriptionsRepo;

	private Long assoId;

	private Association asso;
	
	private UserAccount userAccount;
	
	public List<Association> getAllAssociations(){
		return assoRepo.findAll();
	}
	
	public UserAccount getOneUser() {
		userAccount = userRepo.findByOneIdWithSubscriptions(SessionUtils.getLoggedUserIdFromSession());
		return userAccount;
	}
	
	public Association attributListner(ActionEvent event) {
		asso = (Association) event.getComponent().getAttributes().get("asso");
		return asso;
	}	
	
	public List<UserAccount> recupAllMembersOfAssoc() {
		
		UserAccount user = getOneUser();
		if( !UserRole.ADMIN.equals(user.getPrimaryRole()) ) {
			return Collections.emptyList();
		}
		
		List<Subscription> subsOfAssociation = subscriptionsRepo.findSubscriptionsOfAssociation(user.getAssociation().getId());
		return subsOfAssociation
				.parallelStream()
				.map(Subscription::getAccount)
				.collect(Collectors.toList());
	}
	
	
	public String subscribeToAsso() {
		UserAccount userConnecte = getOneUser();
		
		//récupérer l'asso clické ! 
		FacesContext fc = FacesContext.getCurrentInstance();
		
		Long cePUTAINdidAssoDeMERDE = Long.parseLong(fc.getExternalContext().getRequestParameterMap().get("assoIdjpp"));
		Association assoRecup = assoRepo.findOneById(cePUTAINdidAssoDeMERDE);
		
		Subscription subscription = new Subscription();
		subscription.setDateOfMembership(new Date());
		subscription.setAccount(userConnecte);
		subscription.setAssociation(assoRecup);
		
		userConnecte.updateUserRole(UserRole.MEMBER);
		userConnecte.updateSelectedAssociation(cePUTAINdidAssoDeMERDE);
		userConnecte.addSubscription(subscription);
				
		userRepo.majProfile(userConnecte);
		
		return "/index.xhtml?faces-redirect=true";
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
