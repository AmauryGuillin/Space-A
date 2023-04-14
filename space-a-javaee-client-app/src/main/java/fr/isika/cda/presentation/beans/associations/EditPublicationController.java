package fr.isika.cda.presentation.beans.associations;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.entities.association.services.Publication;

@ManagedBean
public class EditPublicationController implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8426808289757260052L;
	
	@Inject
	private AssociationRepository assoRepo;

	public List<Publication> getAllPubli(){
		return assoRepo.findAllPubli();
	}
	
	public String deletePubli(Long publiId) {
		assoRepo.deletePubli(publiId);
		return "/publiList.xhtml?faces-redirect=true"; 
	}

}
