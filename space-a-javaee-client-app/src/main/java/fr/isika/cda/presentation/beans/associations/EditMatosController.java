package fr.isika.cda.presentation.beans.associations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.jws.soap.SOAPBinding.Use;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.services.Publication;
import fr.isika.cda.entities.association.services.StuffToRent;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.utils.SessionUtils;

@ManagedBean
public class EditMatosController implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8426808289757260052L;
	
	@Inject
	private UserAccountRepository userRepo;
	
	@Inject
	private AssociationRepository assoRepo;

	public List<StuffToRent> getAllMatos(){
		return assoRepo.findAllMatos();
	}
	
	public List<StuffToRent> getAllMatosOneAsso(){
		List <StuffToRent> listAllStuff = assoRepo.findAllMatos();
		List <StuffToRent> listReturn = new ArrayList<>();
		
		Long userId = SessionUtils.getLoggedUserIdFromSession();
		UserAccount user = userRepo.findByOneId(userId);
		
		for(StuffToRent stuff : listAllStuff) {
			
			if(stuff.getAssociation().getId() == user.getSelectedAssociation()) {
				listReturn.add(stuff);
			}		
		}
		return listReturn;
	}
	
	
	
	public List<StuffToRent> getUserBookedMatos(){
		List <StuffToRent> listAllStuff = assoRepo.findAllMatos();
		List <StuffToRent> listReturn = new ArrayList<>();
		
		Long userId = SessionUtils.getLoggedUserIdFromSession();
		
		for(StuffToRent stuff : listAllStuff) {
			
			if(stuff.getIdUser() == userId) {
				listReturn.add(stuff);
			}		
		}
		return listReturn;
	}
	
	
	
	public String deleteMatos(Long matosId) {
		assoRepo.deleteMatos(matosId);
		return "/dashboardAdminStuff.xhtml?faces-redirect=true"; 
	}
	
	public String bookMatos(Long matosid) {
		
		//recup le user co
		Long userId = SessionUtils.getLoggedUserIdFromSession();
		
		//recup le matériel pour le modif
		StuffToRent stuff = assoRepo.findMatosById(matosid);
		
		//modif le matos
		stuff.setIdUser(userId);
		
		//caler le matos en db
		assoRepo.updateMatos(stuff);
		
	return "/userProfile.xhtml?faces-redirect=true";
	}
	
	public StuffToRent getOneMatos(Long matosId) {
		return assoRepo.findMatosById(matosId);
	}

	
}
