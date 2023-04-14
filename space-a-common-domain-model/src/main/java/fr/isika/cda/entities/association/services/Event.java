package fr.isika.cda.entities.association.services;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.AssociationPlanning;

@Entity
public class Event {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String startDate;

	private String endDate;

	private String description;

	private String title;
	
	@ManyToOne
	private AssociationPlanning associationPlanning;

//	@Enumerated(EnumType.STRING)
//	private EventType eventType;

	public Long getId() {
		return id;
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

	public AssociationPlanning getAssociationPlanning() {
		return associationPlanning;
	}

	public void setAssociationPlanning(AssociationPlanning associationPlanning) {
		this.associationPlanning = associationPlanning;
	}
}
