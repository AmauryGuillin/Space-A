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
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.services.Publication;
import fr.isika.cda.entities.association.services.StuffToRent;
import fr.isika.cda.presentation.beans.users.ShowUserController;
import fr.isika.cda.presentation.utils.FileUpload;

@ManagedBean
@ViewScoped
public class MatosController {
	
	@Inject
	private AssociationRepository assoRepo;
		
	@Inject
	private ShowUserController showUserController;
	
	private StuffToRent matos = new StuffToRent();

	
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
