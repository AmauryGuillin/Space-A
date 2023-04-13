package fr.isika.cda.entities.association.functionnality;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PublicationType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String namePublicationType;

	public String getNamePublicationType() {
		return namePublicationType;
	}

	public void setNamePublicationType(String namePublicationType) {
		this.namePublicationType = namePublicationType;
	}

	public Long getId() {
		return id;
	}


	
}
