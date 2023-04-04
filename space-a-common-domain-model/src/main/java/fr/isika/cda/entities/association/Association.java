package fr.isika.cda.entities.association;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import fr.isika.cda.entities.association.graphic.AssociationSpace;
import fr.isika.cda.entities.users.AssociationSubscriber;

@Entity
public class Association {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String legalName;
	private String registrationNumber;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<AssociationSubscriber> listAssoSubscribers = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private AssociationSpace associationSpace;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private AssociationIdentity associationIdentity;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private AssociationDepiction associationDepiction;
	
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private AssociationPlanning associationPlanning;
	
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public Long getId() {
		return id;
	}
	public AssociationSpace getAssociationSpace() {
		return associationSpace;
	}
	public void setAssociationSpace(AssociationSpace associationSpace) {
		this.associationSpace = associationSpace;
	}
	public AssociationIdentity getAssociationIdentity() {
		return associationIdentity;
	}
	public void setAssociationIdentity(AssociationIdentity associationIdentity) {
		this.associationIdentity = associationIdentity;
	}
	public AssociationDepiction getAssociationDepiction() {
		return associationDepiction;
	}
	public void setAssociationDepiction(AssociationDepiction associationDepiction) {
		this.associationDepiction = associationDepiction;
	}
	public AssociationPlanning getAssociationPlanning() {
		return associationPlanning;
	}
	public void setAssociationPlanning(AssociationPlanning associationPlanning) {
		this.associationPlanning = associationPlanning;
	}
	public List<AssociationSubscriber> getListAssoSubscribers() {
		return listAssoSubscribers;
	}
	public void setListAssoSubscribers(List<AssociationSubscriber> listAssoSubscribers) {
		this.listAssoSubscribers = listAssoSubscribers;
	}


	
	

	
	
	
}
