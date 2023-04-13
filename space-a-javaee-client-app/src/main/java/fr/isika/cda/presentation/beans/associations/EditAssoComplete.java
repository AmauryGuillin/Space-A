package fr.isika.cda.presentation.beans.associations;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.beans.users.UserLoginController;

@ManagedBean
public class EditAssoComplete {

	private Association asso;
	private UserAccount userAccount;
	private Long userId;
	
	@Inject 
	private AssociationRepository assoRepo;
	
	@Inject 
	private UserAccountRepository userRepo;
	
	@Inject
	private UserLoginController userLoginController;
	
	public Association getOneAsso() {
		if (userAccount == null) {
			userId = userLoginController.displayUserId();
			userAccount = userRepo.findByOneId(userId);
			asso = assoRepo.findOneById(userAccount.getAssociation().getId());
		}
		return asso;
	}

	public String updateAsso() {
		assoRepo.majAsso(asso);
		return "/dashboardAdmin.xhtml?faces-redirect=true";
	}
	
	
	
}
