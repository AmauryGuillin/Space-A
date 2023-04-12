package fr.isika.cda.entities.association.services;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.users.UserAccount;

@Entity
@Table(name = "stuff_to_rent")
public class StuffToRent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private Date startDate;
	private Date endDate;
	private String rentingType;

	@ManyToOne(cascade = CascadeType.ALL)
	private Association association;

	@ManyToOne(cascade = CascadeType.ALL)
	private UserAccount userAccount;

	// getters and setters, exception setter deleted on id

	public Long getId() {
		return id;
	}

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

	public String getRentingType() {
		return rentingType;
	}

	public void setRentingType(String rentingType) {
		this.rentingType = rentingType;
	}

}
