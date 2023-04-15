package fr.isika.cda.presentation.beans.associations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.entities.association.services.Activity;
import fr.isika.cda.entities.association.services.Event;
import fr.isika.cda.entities.association.services.Publication;
import fr.isika.cda.entities.association.services.StuffToRent;
import fr.isika.cda.presentation.utils.SessionUtils;

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
	
	
	public String bookActivity(Long activityId) {
		
		//recup le user co
		Long userId = SessionUtils.getLoggedUserIdFromSession();
		
		//recup le matériel pour le modif
		Activity activity = assoRepo.findActivityById(activityId);
		
		//modif le matos
		activity.setIdUser(userId);
		
		//caler le matos en db
		assoRepo.updateActivity(activity);
		
	return "/userProfile.xhtml?faces-redirect=true";
	}
	
	public List<Activity> getUserBookedActivity(){
		List <Activity> listAllActivity = assoRepo.findAllActivities();
		List <Activity> listReturn = new ArrayList<>();
		
		Long userId = SessionUtils.getLoggedUserIdFromSession();
		
		for(Activity activity : listAllActivity) {
			
			if(activity.getIdUser() == userId) {
				listReturn.add(activity);
			}		
		}
		return listReturn;
	}

}
