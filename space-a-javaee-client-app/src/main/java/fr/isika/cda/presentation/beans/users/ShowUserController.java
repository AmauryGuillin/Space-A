package fr.isika.cda.presentation.beans.users;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.servlet.http.Part;

import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.beans.users.viewmodels.UserViewModel;

@ManagedBean
public class ShowUserController {

	@Inject
	private UserAccountRepository userAccountRepo;

	@Inject
	private UserLoginController userLoginController;

	private UserViewModel userVM = new UserViewModel();

	private Long userId;
	private String userName;
	private UserAccount userAccount;


	@PostConstruct
	public void init() {
		userAccount = getOneUser();
	}

	public UserAccount getOneUser() {
		if (userAccount == null) {
			userId = userLoginController.displayUserId();
			userAccount = userAccountRepo.findByOneId(userId);
		}
		return userAccount;
	}

	public void getOneUserById(Long id) {
		userAccount = userAccountRepo.findByOneId(id);
	}

	public void getOneUserByName() {
		userAccount = userAccountRepo.findByOneName(userName);
	}

	public String updateEntity() {
		userAccountRepo.majProfile(userAccount);
		return "/index.xhtml?faces-redirect=true";

	}
	
	public void uploadFile() {
		
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
