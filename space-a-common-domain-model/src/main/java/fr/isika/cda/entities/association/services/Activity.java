package fr.isika.cda.entities.association.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.AssociationPlanning;
import fr.isika.cda.entities.users.UserAccount;

@Entity
public class Activity {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal (TemporalType.DATE)
	private Date startDate;

	@Temporal (TemporalType.DATE)
	private Date endDate;

	private String description;

	private String title;
	
	private String activityType;
	
	private int maxCapacity;
	
	private String eventType;
	
	private Long idUser;
	
	@ManyToMany
	private List<UserAccount> subscribers = new ArrayList<>();
		
	@ManyToOne
	private Association association;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

//	public List<UserAccount> getRegisteredList() {
//		return registeredList;
//	}
//
//	public void setRegisteredList(List<UserAccount> registeredList) {
//		this.registeredList = registeredList;
//	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public List<UserAccount> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(List<UserAccount> subscribers) {
		this.subscribers = subscribers;
	}
	
	public boolean addSubscriber(UserAccount account) {
		return this.subscribers.add(account);
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


}
