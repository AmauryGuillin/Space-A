package fr.isika.cda.entities.association;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import fr.isika.cda.entities.association.graphic.AssociationSpace;

@Entity
public class Association {

	
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String legalName;
	private String registrationNumber;
	
//A RACCORDER A MANAGER !!!!!!! AMAURY
	
	//A RACCORDER A STUFFTORENT
	//A RACCORDER A ASSOCIAITON SUBSCRIBER
	
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
	


	
	
	
}
