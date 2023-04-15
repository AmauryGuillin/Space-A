package fr.isika.cda.spring.business.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.isika.cda.entities.association.Association;
import fr.isika.cda.spring.AppCollectionUtils;
import fr.isika.cda.spring.business.repo.AssociationSpaceRepo;

@Service
@Transactional
public class AssociationSpaceService {
	
	@Autowired
	private AssociationSpaceRepo associationSpaceRepo;
	
	public Optional<Association> byId(final Long id){
		return associationSpaceRepo.findById(id);
	}
	
	public void remove(final Long id) {
		associationSpaceRepo.deleteById(id);
	}
	
	public List<Association> all() {
		return AppCollectionUtils.asList(associationSpaceRepo.findAll());
	}
	

}
