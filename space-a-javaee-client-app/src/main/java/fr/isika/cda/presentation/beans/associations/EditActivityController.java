package fr.isika.cda.presentation.beans.associations;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.entities.association.services.Activity;
import fr.isika.cda.entities.association.services.Event;
import fr.isika.cda.entities.association.services.Publication;

@ManagedBean
public class EditActivityController implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7428586284253557640L;
	
	@Inject
	private AssociationRepository assoRepo;

	public List<Activity> getAllActivities(){
		return assoRepo.findAllActivities();
	}
	
	public String deleteActivity(Long activityId) {
		assoRepo.deleteActivity(activityId);
		return "/activityList.xhtml?faces-redirect=true"; 
	}

}
