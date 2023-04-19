package fr.isika.cda.entities.association.functionnality;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActivityType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameActivityType;

	public String getNameActivityType() {
		return nameActivityType;
	}

	public void setNameActivityType(String nameActivityType) {
		this.nameActivityType = nameActivityType;
	}

	public Long getId() {
		return id;
	}


}
