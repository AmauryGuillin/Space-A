package fr.isika.cda.entities.assoService;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.isika.cda.entities.association.AssociationPlanning;
import fr.isika.cda.entities.association.functionnality.ActivityType;

@Entity
public class Activity {
	
	@Id
	@GeneratedValue
	private Long id; 
	
	private String title;
	
	private String description;
	
	private String imagePath;
	
	private int maxCapacity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private AssociationPlanning associationPlanning;
	
	//A VOIR
	//private List<String> registerdList;
	
	@Enumerated(EnumType.STRING)
	private ActivityType activityType;
	
	@Temporal (TemporalType.DATE)
    private Date startDate = new Date();
	
	@Temporal (TemporalType.DATE)
	private Date endDate = new Date();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
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

	public Long getId() {
		return id;
	} 
	
	
	

}
