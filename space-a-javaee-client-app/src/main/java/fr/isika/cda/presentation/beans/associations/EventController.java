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
import fr.isika.cda.entities.association.functionnality.ConfigType;
import fr.isika.cda.entities.association.functionnality.EventType;
import fr.isika.cda.entities.association.services.Event;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.beans.users.ShowUserController;
import fr.isika.cda.presentation.beans.users.UserLoginController;


@ManagedBean
public class EventController {


	private Long eventId;
	private Date startDate;
	private Date endDate;
	private String description;
	private String title;
	
	private Event event = new Event();

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

	public String createEvent() {
		
		Association asso = showUserController.getUserSelectedAssociation();

		//Creation Event
		event.setTitle(event.getTitle());
		event.setStartDate(event.getStartDate());
		event.setEndDate(event.getEndDate());
		event.setDescription(event.getDescription());
		event.setEventType(event.getEventType());
		event.setAssociation(asso);
		event.setImgEvent("img-event-basic.png");
		
		//event en bdd
		assoRepo.createEvent(event);

		return "/dashboardAdminEvt.xhtml?faces-redirect=true"; 
	}
	
	public Association getOneAsso() {
		if (userAccount == null) {
			userId = userLoginController.displayUserId();
			userAccount = userRepo.findByOneId(userId);
			asso = assoRepo.findOneById(userAccount.getAssociation().getId());
		}
		return asso;
	}
	
	public List<EventType> getListEvents(){
		ConfigType configType = getOneAsso().getAssociationFunctionnality().getConfigType();
		return assoRepo.getAllEventsByConfigTypeId(configType.getId());
	}

	// GETTERS AND SETTERS

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public AssociationRepository getAssoRepo() {
		return assoRepo;
	}

	public void setAssoRepo(AssociationRepository assoRepo) {
		this.assoRepo = assoRepo;
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

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
}
