package fr.isika.cda.entities.association.functionnality;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asso_subrscriber_control")
public class AssociationSubscriberControl {
	@Id
	@GeneratedValue
	private Long id; 
	
	private boolean ageControl; 
	
	private int minAgeSetUp;
	
	private boolean mandatoryDocument;
	
	private String requiredDocuments;

	public boolean getAgeControl() {
		return ageControl;
	}
	public Long getId() {
		return id;
	} 

	public void setAgeControl(boolean ageControl) {
		this.ageControl = ageControl;
	}

	public int getMinAgeSetUp() {
		return minAgeSetUp;
	}

	public void setMinAgeSetUp(int minAgeSetUp) {
		this.minAgeSetUp = minAgeSetUp;
	}

	public boolean isMandatoryDocument() {
		return mandatoryDocument;
	}

	public void setMandatoryDocument(boolean mandatoryDocument) {
		this.mandatoryDocument = mandatoryDocument;
	}

	public String getRequiredDocuments() {
		return requiredDocuments;
	}

	public void setRequiredDocuments(String requiredDocuments) {
		this.requiredDocuments = requiredDocuments;
	}

	

}
