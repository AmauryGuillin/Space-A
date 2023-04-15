package fr.isika.cda.presentation.beans.users;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.subscriptions.Subscription;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.beans.users.viewmodels.UserViewModel;
import fr.isika.cda.presentation.utils.FileUpload;
import fr.isika.cda.presentation.utils.SessionUtils;

@ManagedBean
@ViewScoped
public class ShowUserController {

	@Inject
	private UserAccountRepository userAccountRepo;

	@Inject
	private UserLoginController userLoginController;
	
	@Inject
	private AssociationRepository associationRepo;

	private UserViewModel userVM = new UserViewModel();

	private Long userId;
	private Association asso;
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
			userAccount = userAccountRepo.findByOneIdWithSubscriptions(userId);
		}
		return userAccount;
	}

	public void getOneUserById(Long id) {
		userAccount = userAccountRepo.findByOneId(id);
	}
	
	public UserAccount returnOneUserById(Long id) {
		userAccount = userAccountRepo.findByOneId(id);
		return userAccount;
	}

	public void getOneUserByName() {
		userAccount = userAccountRepo.findByOneName(userName);
	}
	
	public Association getAssociationSelected() {
		
		//Je récupère mon user connecté complet 
		UserAccount userConnected = connectedUser();
		
		//je récupère l'id de l'asso connecté qui est par défaut Spac'A 1
		Long assoIdSelected = userConnected.getSelectedAssociation();
		
		//je récupère l'association sélectionné complète
		Association assoSelect = associationRepo.findOneById(assoIdSelected);
		
		return assoSelect;
	}

	public String updateEntity() {
		System.out.println("********************************* METHODE UPDATE");
		userAccountRepo.majProfile(userAccount);
		return "/userProfile.xhtml?faces-redirect=true";
	}
	
	public UserAccount connectedUser() {
		UserAccount user = getOneUser();
		UserAccount anotherUser  = userAccountRepo.findByOneId(user.getUserId());	
		return anotherUser;
	}
	
	public Association getUserSelectedAssociation() {
		UserAccount user = connectedUser();
		Association asso = associationRepo.findOneById(user.getSelectedAssociation());
		return asso;
	}
	
	public void uploadFile(FileUploadEvent event) {
		System.out.println("********************************* METHODE FILEUPLOAD");
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMYYYY_hhmmss"));
		UploadedFile file = event.getFile();
		avatarFileName = timestamp + "_" + file.getFileName();
		FileUpload.doUpload(file, avatarFileName);
		
		System.out.println("*********************************************" + avatarFileName);
		
		userAccount.getUserProfile().setAvatar(avatarFileName);
		
	}
	
	public List<Association> currentUserAssociationSubscriptions() {
		userId = userLoginController.displayUserId();
		List<Subscription> subscriptions = userAccountRepo.findUserSubscriptions(userId);
		return subscriptions
				.parallelStream()
				.map(Subscription::getAssociation)
				.collect(Collectors.toList());
	}
	
	public Association editSelectAssociation(ActionEvent event) {
		//je récupère l'asso clické
		asso = (Association) event.getComponent().getAttributes().get("asso");
		//je récupère mon user
		userAccount = getOneUser();
		
		//je modifie mon user avec l'asso
		userAccount.updateSelectedAssociation(asso.getId());
		
		//je sauv en db
		userAccountRepo.majProfile(userAccount);		
		return asso;		
	}	


	public String deleteUser(Long userId) {
		userAccountRepo.remove(userId);
		return "/index.xhtml?faces-redirect=true"; 
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

}
