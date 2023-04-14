package fr.isika.cda.presentation.beans.associations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.functionnality.ConfigType;
import fr.isika.cda.entities.association.functionnality.EventType;
import fr.isika.cda.entities.association.functionnality.PublicationType;
import fr.isika.cda.entities.association.services.Publication;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.beans.users.ShowUserController;
import fr.isika.cda.presentation.beans.users.UserLoginController;
import fr.isika.cda.presentation.utils.FileUpload;

@ManagedBean
@ViewScoped
public class PubliController {
	
	@Inject
	private AssociationRepository assoRepo;
		
	@Inject
	private ShowUserController showUserController;
	
	@Inject
	private UserLoginController userLoginController;
	
	@Inject 
	private UserAccountRepository userRepo;
	
	private String imageUrl;
	private Association asso;
	private UserAccount userAccount;
	private Long userId;

	private Publication publi = new Publication();


	public void uploadImagePath(FileUploadEvent event) {
		System.out.println("********************************* METHODE FILEUPLOAD");
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMYYYY_hhmmss"));
		UploadedFile file = event.getFile();
		imageUrl = timestamp + "_" + file.getFileName();
		FileUpload.doUpload(file, imageUrl);
		
		System.out.println("*********************************************" + imageUrl);
		
		publi.setImagePath(imageUrl);
		
	}
	
	public String createPubli() {
		
		Association asso = showUserController.getUserSelectedAssociation();


		//Creation Publi
		publi.setTitle(publi.getTitle());
		publi.setDescription(publi.getDescription());
		publi.setImagePath(publi.getImagePath());
		publi.setAuthor(publi.getAuthor());
		publi.setAssociation(asso);
		
		//publi en bdd
		assoRepo.createPubli(publi);
		

		return "/dashboardAdmin.xhtml?faces-redirect=true"; 
	}
	
	
	public Association getOneAsso() {
		if (userAccount == null) {
			userId = userLoginController.displayUserId();
			userAccount = userRepo.findByOneId(userId);
			asso = assoRepo.findOneById(userAccount.getAssociation().getId());
		}
		return asso;
	}
	
	public List<PublicationType> getListPublications(){
		ConfigType configType = getOneAsso().getAssociationFunctionnality().getConfigType();
		return assoRepo.getAllPublicationByConfigTypeId(configType.getId());
	}
	
	
	
	
	// GETTERS AND SETTERS
	
	public Publication getPubli() {
		return publi;
	}

	public void setPubli(Publication publi) {
		this.publi = publi;
	}
	
}
