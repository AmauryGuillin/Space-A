package fr.isika.cda.entities.users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import fr.isika.cda.entities.association.Association;

@Entity
public class AssociationSubscriber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private boolean membershipStatus;
	
	private Date dateOfMembership;
	
	private String justification;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ASSOCIATION_SUBSCRIBER",
	joinColumns = @JoinColumn (name="ASSOCIATION_ID"),
	inverseJoinColumns=@JoinColumn(name="ASSOCIATIONSUBSCRIBER_ID"))
	private List<Association> listAssociations = new ArrayList<>();
	
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
	
	public List<Association> getAssociations() {
		return Collections.unmodifiableList(listAssociations);
	}

	public boolean addAssociationToUser(Association association) {
		return this.listAssociations.add(association);
	}

	@Override
	public String toString() {
		return "AssociationSubscriber [id=" + id + ", membershipStatus=" + membershipStatus + ", dateOfMembership="
				+ dateOfMembership + ", justification=" + justification + ", listAssociations=" + listAssociations
				+ "]";
	}
	
	




}
