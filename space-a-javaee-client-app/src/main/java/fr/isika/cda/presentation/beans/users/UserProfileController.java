package fr.isika.cda.presentation.beans.users;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.presentation.utils.SessionUtils;

@ManagedBean
public class UserProfileController implements Serializable {

	/**
	 * 
	 */
	

	private static final long serialVersionUID = 536657576401406471L;

	@Inject
	private UserAccountRepository userAccountRepo;
	
	public String deleteProfile() {
		Long idToDelete = SessionUtils.getLoggedUserIdFromSession();
		userAccountRepo.remove(idToDelete);
		SessionUtils.resetUserSessionAttributes();
		return "/index.xhtml?faces-redirect=true";
	}
			
}
