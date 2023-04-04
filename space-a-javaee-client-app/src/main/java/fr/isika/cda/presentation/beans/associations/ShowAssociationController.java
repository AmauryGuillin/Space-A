package fr.isika.cda.presentation.beans.associations;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.entities.association.Association;

@ManagedBean	
public class ShowAssociationController {

	@Inject
	private AssociationRepository assoRepo;
	
	public List<Association> getAllAssociations(){
		return assoRepo.findAll();
	}
	
	
}
