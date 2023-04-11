package fr.isika.cda.presentation.beans.users;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.data.repositories.users.associationSubscriberRepo;
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.users.AssociationSubscriber;
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

	private AssociationSubscriber selectedAssociation;
	
	private Long userId;
	private String userName;
	private UserAccount userAccount;
	private String avatarFileName;
	private UploadedFile file;


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
		System.out.println("********************************* METHODE UPDATE");
		userAccountRepo.majProfile(userAccount);
		return "/index.xhtml?faces-redirect=true";
	}
	
	
	
	public void uploadFile(FileUploadEvent event) {
		System.out.println("********************************* METHODE FILEUPLOAD");
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMYYYY_hhmmss"));
		UploadedFile file = event.getFile();
		avatarFileName = timestamp + "_" + file.getFileName();
		FileUpload.doUpload(file, avatarFileName);
		userId = userLoginController.displayUserId();
		userAccount = userAccountRepo.findByOneId(userId);
		userAccount.getUserProfile().setAvatar(avatarFileName);
		
	}
	
	public List<Association> getAllAssociationSubscriber() {
		userId = userLoginController.displayUserId();
		return userAccountRepo.findAllAssociationSub(userId);
	}
	
	
	public Association editSelectAssociation(ActionEvent event) {
		//je récupère l'asso clické
		Association asso = (Association) event.getComponent().getAttributes().get("asso");
		//je récupère mon user
		userAccount = getOneUser();
		
		//je modifie mon user avec l'asso
		userAccount.setSelectedAssociation(asso.getId());
		
		//je sauv en db
		userAccountRepo.majProfile(userAccount);
		System.out.println("USERACCOUT : " + userAccount);
		System.out.println("ASSO : " + asso);		
		return asso;		
	}	
	

//	private AssociationSubscriber getOneAssocitionSubscriberById(Long id) {
//		AssociationSubscriber associationSubscriber = null;
//	    try {
//	        associationSubscriberRepo.findById(id);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    return associationSubscriber;
//	}


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

	public String getAvatarFileName() {
		return avatarFileName;
	}

	public void setAvatarFileName(String avatarFileName) {
		this.avatarFileName = avatarFileName;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public AssociationSubscriber getSelectedAssociation() {
		return selectedAssociation;
	}

	public void setSelectedAssociation(AssociationSubscriber selectedAssociation) {
		this.selectedAssociation = selectedAssociation;
	}
	
	
	
	



}
