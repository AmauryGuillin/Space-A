package fr.isika.cda.presentation.beans.associations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.services.Activity;
import fr.isika.cda.entities.association.services.Event;
import fr.isika.cda.entities.association.services.Publication;
import fr.isika.cda.entities.association.services.StuffToRent;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.utils.SessionUtils;

@ManagedBean
public class EditActivityController implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7428586284253557640L;
	
	@Inject
	private AssociationRepository assoRepo;
	
	@Inject
	private UserAccountRepository userRepo;

	public List<Activity> getAllActivities(){
		return assoRepo.findAllActivities();
	}
	
	public List<Activity> getAllActivitiesOneAsso(){
		List <Activity> listAllActivities = assoRepo.findAllActivities();
		List <Activity> listReturn = new ArrayList<>();
		
		Long userId = SessionUtils.getLoggedUserIdFromSession();
		UserAccount user = userRepo.findByOneId(userId);
		
		for(Activity activity : listAllActivities) {
			
			if(activity.getAssociation().getId() == user.getSelectedAssociation()) {
				listReturn.add(activity);
			}		
		}
		return listReturn;
	}
	
	
	public String deleteActivity(Long activityId) {
		assoRepo.deleteActivity(activityId);
		return "/dashboardAdminAct.xhtml?faces-redirect=true"; 
	}
	
	
	public String bookActivity(Long activityId) {
		
		//recup le user co
		Long userId = SessionUtils.getLoggedUserIdFromSession();
		UserAccount user = userRepo.findByOneId(userId);

		//recup le matériel pour le modif
		Activity activity = assoRepo.findActivityByIdWithSubscribers(activityId);
		
		//modif le matos
		activity.addSubscriber(user);
		
		//caler le matos en db
		assoRepo.updateActivity(activity);
		
	return "/userProfile.xhtml?faces-redirect=true";
	}
	
//	public List<Activity> getUserBookedActivity(){
//		List <Activity> listAllActivity = assoRepo.findAllActivities();
//		List <Activity> listReturn = new ArrayList<>();
//		
//		Long userId = SessionUtils.getLoggedUserIdFromSession();
//		
//		for(Activity activity : listAllActivity) {
//			
//			if(activity.getIdUser() == userId) {
//				listReturn.add(activity);
//			}		
//		}
//		return listReturn;
//	}
	
	public List<Activity> getUserBookedActivity(){
		List <Activity> listAllActivity = assoRepo.findAllActivitiesWithSubscribers();
		List <Activity> listReturn = new ArrayList<>();
		
		Long userId = SessionUtils.getLoggedUserIdFromSession();
		UserAccount user = userRepo.findByOneId(userId);

		for(Activity activity : listAllActivity) {
			
			if(activity.getSubscribers().contains(user)) {
				listReturn.add(activity);
			}		
		}
		return listReturn;
	}

	
	
	public List<String> getActivityRegisteredUsers(Long activityId) {
		List<Long> registeredUsersIds = assoRepo.findAllUsersRegisteredToOneActivity(activityId);
		
		// get the list, stream liste d'infos, map : mappe chaque compte en username, collect transforme en liste
		List<String> registeredUsersNames = registeredUsersIds.stream()
				.map(id -> userRepo.findByOneId(id).getUsername())
				.collect(Collectors.toList());

		return registeredUsersNames;
	}
	
	public int NbRemainingPlaces(Long activityId){
		Activity activity = assoRepo.findActivityById(activityId);
		int resa = getActivityRegisteredUsers(activityId).size();
		int places = activity.getMaxCapacity() - resa;
		return places;
	}


}
