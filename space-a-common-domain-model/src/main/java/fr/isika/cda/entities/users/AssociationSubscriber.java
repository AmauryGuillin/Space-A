package fr.isika.cda.entities.users;

import java.util.Date;
import java.util.LinkedList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import fr.isika.cda.entities.association.Association;

@Entity
public class AssociationSubscriber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private boolean membershipStatus;
	
	@Column(nullable = false)
	private Date dateOfMembership;
	
	private String justification;

	public boolean isMembershipStatus() {
		return membershipStatus;
	}

	public void setMembershipStatus(boolean membershipStatus) {
		this.membershipStatus = membershipStatus;
	}

	public Date getDateOfMembership() {
		return dateOfMembership;
	}

	public void setDateOfMembership(Date dateOfMembership) {
		this.dateOfMembership = dateOfMembership;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Long getId() {
		return id;
	}
	

}
