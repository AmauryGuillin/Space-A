package fr.isika.cda.presentation.beans.users;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.beans.users.viewmodels.UserViewModel;
import fr.isika.cda.presentation.utils.FileUpload;

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
	private String avatarFileName;


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
	
	
	public void uploadFile(FileUploadEvent event) {
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMYYYY_hhmmss"));
		UploadedFile file = event.getFile();
		avatarFileName = timestamp + "_" + file.getFileName();
		FileUpload.doUpload(file, avatarFileName);
		
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
