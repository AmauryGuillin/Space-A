package fr.isika.cda.entities.association;

import java.util.ArrayList; 
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	
	@Column(length = 50, nullable = false, unique = true)
	private String legalName;
	
	@Column(name="registration_number_siret", nullable = false, length = 17, unique = true)
	private String registrationNumber;
		
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private AssociationSpace associationSpace;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private AssociationIdentity associationIdentity;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private AssociationPlanning associationPlanning;
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
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

	public AssociationPlanning getAssociationPlanning() {
		return associationPlanning;
	}
	public void setAssociationPlanning(AssociationPlanning associationPlanning) {
		this.associationPlanning = associationPlanning;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Association [id=");
		builder.append(id);
		builder.append(", legalName=");
		builder.append(legalName);
		builder.append(", registrationNumber=");
		builder.append(registrationNumber);
		builder.append(", associationSpace=");
		builder.append(associationSpace);
		builder.append(", associationIdentity=");
		builder.append(associationIdentity);
		builder.append(", associationPlanning=");
		builder.append(associationPlanning);
		builder.append("]");
		return builder.toString();
	}

	

	
	

	
	
	
}
