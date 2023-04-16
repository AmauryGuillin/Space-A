package fr.isika.cda.entities.association.services;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.AssociationPlanning;

@Entity
public class Event {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal (TemporalType.DATE)
	private Date startDate;

	@Temporal (TemporalType.DATE)
	private Date endDate;

	@Column(length = 2000, nullable = true)
	private String description;
	
	private String imgEvent;

	private String title;
	
	private String eventType;
	
	@ManyToOne
	private Association association;


	public Long getId() {
		return id;
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

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}


	public String getEventType() {
		return eventType;
	}


	public void setEventType(String eventType) {
		this.eventType = eventType;
	}


	public String getImgEvent() {
		return imgEvent;
	}


	public void setImgEvent(String imgEvent) {
		this.imgEvent = imgEvent;
	}

}
