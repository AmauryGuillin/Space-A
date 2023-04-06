package fr.isika.cda.presentation.beans.users;


import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.beans.users.viewmodels.CreateAccountViewModel;
import fr.isika.cda.presentation.beans.users.viewmodels.UserViewModel;

@ManagedBean
public class ShowUserController {
	
	@Inject
	private UserAccountRepository userAccountRepo;

	private UserViewModel userVM = new UserViewModel();

	
	private Long userId;
	private String userName;
	private UserAccount userAccount;
	
	public void getOneUser() {
		userAccount = userAccountRepo.findByOneId(userId);
	}
	
	public void getOneUserByName() {
		userAccount = userAccountRepo.findByOneName(userName);
	}


	public String majProfile(Long id) {
		UserAccount account = majProfileFromVM(id);
		userAccountRepo.majProfile(account);
		userVM = new UserViewModel(); // Reset VM
		return "/index.xhtml?faces-redirect=true";
	}



	private UserAccount majProfileFromVM(Long id) {
		userAccount = userAccountRepo.findByOneId(id);
		userAccount.getUserProfile().getContact().getAddress().setCity(userVM.getCity());
		return userAccount;
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
		
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserViewModel getUserVM() {
		return userVM;
	}

	public void setUserVM(UserViewModel userVM) {
		this.userVM = userVM;
	}
	
	
	
}
