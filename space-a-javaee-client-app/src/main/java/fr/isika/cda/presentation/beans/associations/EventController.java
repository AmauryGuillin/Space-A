package fr.isika.cda.presentation.beans.associations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;


import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.AssociationPlanning;
import fr.isika.cda.entities.association.services.Event;
import fr.isika.cda.presentation.beans.users.ShowUserController;


@ManagedBean
public class EventController {


	private Long eventId;
	private String startDate;
	private String endDate;
	private String description;
	private String title;
	
	private Event event = new Event();

	@Inject
	private AssociationRepository assoRepo;
	
	@Inject
	private ShowUserController showUserController;


	public String createEvent() {
		
		Association asso = showUserController.getUserSelectedAssociation();

		//Creation Event
		event.setTitle(event.getTitle());
		event.setStartDate(event.getStartDate());
		event.setEndDate(event.getEndDate());
		event.setDescription(event.getDescription());
		event.setAssociation(asso);
		
		//event en bdd
		assoRepo.createEvent(event);

		return "/dashboardAdmin.xhtml?faces-redirect=true"; 
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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
