package fr.isika.cda.presentation.beans.users;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.transaction.Transactional;

import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserProfile;
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
	
//ABI	
	private UserAccount oneUser;
	
//ABI
	@PostConstruct
    public void init() {
        oneUser = getOneUser();
    }
	
//ABI	
	public UserAccount getOneUser() {
	    if (oneUser == null) {
	        userId = userLoginController.displayUserId();
	        oneUser = userAccountRepo.findByOneId(userId);
	    }
	    return oneUser;
	}
	
	public void getOneUserById(Long id) {
		userAccount = userAccountRepo.findByOneId(id);
	}
	
	public void getOneUserByName() {
		userAccount = userAccountRepo.findByOneName(userName);
	}


//	public String majProfile(Long id, String email) {
//		UserAccount account = majProfileFromVM(id, email);
//		userAccountRepo.majProfile(account);
//		userVM = new UserViewModel(); // Reset VM
//		return "/index.xhtml?faces-redirect=true";
//	}

	//Get
	public String updateProfile(String lastname) {
		userId = userLoginController.displayUserId();
		userAccount = userAccountRepo.findByOneId(userId);
		System.out.println("********************************************************le lastname = " + lastname);
		userAccount.getUserProfile().setLastName(lastname);
		userAccountRepo.majProfile(userAccount);
		return "/index.xhtml?faces-redirect=true";
	}
	
//ABI
	public String updateEntity() {
	    UserProfile profile = oneUser.getUserProfile();
	    profile.setLastName(oneUser.getUserProfile().getLastName());
	    profile.setFirstName(oneUser.getUserProfile().getFirstName());
	    profile.setAvatar(oneUser.getUserProfile().getAvatar());
	    oneUser.setUserProfile(profile);
	    userAccountRepo.majProfile(oneUser);
	    return "/index.xhtml?faces-redirect=true";
	}
	
	//Post
	public void updateUser(Long id, String city) {
		userAccount = userAccountRepo.findByOneId(id);
		userAccount.getUserProfile().getUserContact().getAddress().setCity(city);
		userAccountRepo.majProfile(userAccount);
		
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
