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
	
	private Long assoId;
	private Association asso;
	
	public List<Association> getAllAssociations(){
		return assoRepo.findAll();
	}
	
	public void getOneAssociation() {
		asso = assoRepo.findOneById(assoId);
	}

	
	public AssociationRepository getAssoRepo() {
		return assoRepo;
	}

	public void setAssoRepo(AssociationRepository assoRepo) {
		this.assoRepo = assoRepo;
	}

	public Long getAssoId() {
		return assoId;
	}

	public void setAssoId(Long assoId) {
		this.assoId = assoId;
	}

	public Association getAsso() {
		return asso;
	}

	public void setAsso(Association asso) {
		this.asso = asso;
	}
	
	
	
	
	
}
