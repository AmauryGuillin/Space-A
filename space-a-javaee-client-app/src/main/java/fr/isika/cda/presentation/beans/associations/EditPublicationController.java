package fr.isika.cda.presentation.beans.associations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.services.Publication;
import fr.isika.cda.entities.association.services.StuffToRent;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.utils.SessionUtils;

@ManagedBean
public class EditPublicationController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8426808289757260052L;
	
	@Inject
	private AssociationRepository assoRepo;
	
	@Inject
	private UserAccountRepository userRepo;

	public List<Publication> getAllPubli(){
		return assoRepo.findAllPubli();
	}
	
	public List<Publication> getAllPubliOneAsso(){
		List <Publication> listAllPubli = assoRepo.findAllPubli();
		List <Publication> listReturn = new ArrayList<>();
		
		Long userId = SessionUtils.getLoggedUserIdFromSession();
		UserAccount user = userRepo.findByOneId(userId);
		
		for(Publication publi : listAllPubli) {
			
			if(publi.getAssociation().getId() == user.getSelectedAssociation()) {
				listReturn.add(publi);
			}		
		}
		return listReturn;
	}
	
	public String deletePubli(Long publiId) {
		assoRepo.deletePubli(publiId);
		return "/dashboardAdminPub.xhtml?faces-redirect=true"; 
	}

}
