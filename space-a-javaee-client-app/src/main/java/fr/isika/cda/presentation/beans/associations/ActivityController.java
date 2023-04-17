package fr.isika.cda.presentation.beans.associations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;


import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.AssociationPlanning;
import fr.isika.cda.entities.association.functionnality.ActivityType;
import fr.isika.cda.entities.association.functionnality.ConfigType;
import fr.isika.cda.entities.association.functionnality.EventType;
import fr.isika.cda.entities.association.services.Activity;
import fr.isika.cda.entities.association.services.Event;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.beans.users.ShowUserController;
import fr.isika.cda.presentation.beans.users.UserLoginController;


@ManagedBean
public class ActivityController {


	private Long eventId;
	private Date startDate;
	private Date endDate;
	private String description;
	private String title;
	private int maxCapacity;
	
	private Activity activity = new Activity();

	@Inject
	private AssociationRepository assoRepo;
	
	@Inject
	private ShowUserController showUserController;
	
	@Inject
	private UserLoginController userLoginController;

	@Inject 
	private UserAccountRepository userRepo;
	
	private Association asso;
	private UserAccount userAccount;
	private Long userId;

	public String createActivity() {
		
		Association asso = showUserController.getUserSelectedAssociation();

		//Creation Event
		activity.setTitle(activity.getTitle());
		activity.setStartDate(activity.getStartDate());
		activity.setEndDate(activity.getEndDate());
		activity.setDescription(activity.getDescription());
		activity.setEventType(activity.getEventType());
		activity.setMaxCapacity(activity.getMaxCapacity());
		activity.setAssociation(asso);
		
		//event en bdd
		assoRepo.createActivity(activity);

		return "/dashboardAdminAct.xhtml?faces-redirect=true"; 
	}
	
	public Association getOneAsso() {
		if (userAccount == null) {
			userId = userLoginController.displayUserId();
			userAccount = userRepo.findByOneId(userId);
			asso = assoRepo.findOneById(userAccount.getAssociation().getId());
		}
		return asso;
	}
	
	
	public List<ActivityType> getListActivities(){
		ConfigType configType = getOneAsso().getAssociationFunctionnality().getConfigType();
		return assoRepo.getAllActivitiesByConfigTypeId(configType.getId());
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Association getAsso() {
		return asso;
	}

	public void setAsso(Association asso) {
		this.asso = asso;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	// GETTERS AND SETTERS

	
}
