package fr.isika.cda.presentation.beans.users;


import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.users.UserAccount;

@ManagedBean
public class ShowUserController {
	
	@Inject
	private UserAccountRepository userAccountRepo;

	private Long userId;
	private UserAccount userAccount;
	
	public void getOneUser() {
		userAccount = userAccountRepo.findByOneId(userId);
	}

	public UserAccountRepository getUserAccountRepo() {
		return userAccountRepo;
	}

	public void setUserAccountRepo(UserAccountRepository userAccountRepo) {
		this.userAccountRepo = userAccountRepo;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
		
	
	
	
}
