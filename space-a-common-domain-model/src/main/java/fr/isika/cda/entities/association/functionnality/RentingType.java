package fr.isika.cda.entities.association.functionnality;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RentingType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameRentingType;

	public String getNameRentingType() {
		return nameRentingType;
	}

	public void setNameRentingType(String nameRentingType) {
		this.nameRentingType = nameRentingType;
	}

	public Long getId() {
		return id;
	}


}
