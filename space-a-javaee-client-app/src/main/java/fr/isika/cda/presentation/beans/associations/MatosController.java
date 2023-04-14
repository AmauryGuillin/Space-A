package fr.isika.cda.presentation.beans.associations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
import fr.isika.cda.entities.association.functionnality.RentingType;
import fr.isika.cda.entities.association.services.Publication;
import fr.isika.cda.entities.association.services.StuffToRent;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.beans.users.ShowUserController;
import fr.isika.cda.presentation.beans.users.UserLoginController;
import fr.isika.cda.presentation.utils.FileUpload;

@ManagedBean
@ViewScoped
public class MatosController {
	
	@Inject
	private AssociationRepository assoRepo;
		
	@Inject
	private ShowUserController showUserController;
	
	@Inject
	private UserLoginController userLoginController;

	@Inject 
	private UserAccountRepository userRepo;
	
	private StuffToRent matos = new StuffToRent();

	private Association asso;
	private UserAccount userAccount;
	private Long userId;
	
	public String createMatos() {
		
		Association asso = showUserController.getUserSelectedAssociation();

		//Creation Matos
		matos.setTitle(matos.getTitle());
		matos.setDescription(matos.getDescription());
		matos.setRentingType(matos.getRentingType());
		matos.setStartDate(matos.getStartDate());
		matos.setEndDate(matos.getEndDate());
		matos.setAssociation(asso);

		//matos en bdd
		assoRepo.createMatos(matos);
		

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
	
	public List<RentingType> getListStuffs(){
		ConfigType configType = getOneAsso().getAssociationFunctionnality().getConfigType();
		return assoRepo.getAllStuffByConfigTypeId(configType.getId());
	}

	public StuffToRent getMatos() {
		return matos;
	}



	public void setMatos(StuffToRent matos) {
		this.matos = matos;
	}
	
	
//	public List<Publication> getAllPubli(){
//		return assoRepo.findAllPubli();
//	}
	
	
	
	
	// GETTERS AND SETTERS
	

}
