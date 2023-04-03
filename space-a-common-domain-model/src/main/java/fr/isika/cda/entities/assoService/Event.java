package fr.isika.cda.entities.assoService;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.isika.cda.entities.association.AssociationPlanning;

@Entity
public class Event {
	@Id
	@GeneratedValue
	private Long id; 
	
	private Date startDate;
	
	private Date endDate; 
	
	private String description; 
	
	private String title;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private AssociationPlanning associationPlanning;
	
//	@Enumerated(EnumType.STRING)
//	private EventType eventType;
	
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


}
