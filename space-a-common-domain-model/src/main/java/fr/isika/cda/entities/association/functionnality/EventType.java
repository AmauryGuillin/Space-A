package fr.isika.cda.entities.association.functionnality;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EventType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameEventType;

	public String getNameEventType() {
		return nameEventType;
	}

	public void setNameEventType(String nameEventType) {
		this.nameEventType = nameEventType;
	}

	public Long getId() {
		return id;
	}



	
	
	
}
