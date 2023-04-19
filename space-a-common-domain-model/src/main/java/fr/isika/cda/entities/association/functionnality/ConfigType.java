package fr.isika.cda.entities.association.functionnality;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ConfigType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EventType> events = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PublicationType> publications = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ActivityType> activities = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RentingType> rentals = new ArrayList<>();

	
	/*
	 * Methode addType
	 */
	
	public boolean addEventType(final EventType event) {
	    return this.events.add(event);
	}
	
	public boolean addPublicationsType(final PublicationType publication) {
	    return this.publications.add(publication);
	}
	
	public boolean addActivityType(final ActivityType activity) {
	    return this.activities.add(activity);
	}
	
	public boolean addRentingType(final RentingType renting) {
	    return this.rentals.add(renting);
	}
	
	/*
	 * Getters et setters
	 */

	public List<EventType> getEvents() {
		return events;
	}

	public void setEvents(List<EventType> events) {
		this.events = events;
	}

	public List<PublicationType> getPublications() {
		return publications;
	}

	public void setPublications(List<PublicationType> publications) {
		this.publications = publications;
	}

	public List<ActivityType> getActivities() {
		return activities;
	}

	public void setActivities(List<ActivityType> activities) {
		this.activities = activities;
	}

	public List<RentingType> getRentals() {
		return rentals;
	}

	public void setRentals(List<RentingType> rentals) {
		this.rentals = rentals;
	}

	public Long getId() {
		return id;
	}
	
	

	
	
	

	
}
