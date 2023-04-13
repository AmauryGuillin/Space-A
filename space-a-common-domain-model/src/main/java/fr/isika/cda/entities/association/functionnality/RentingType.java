package fr.isika.cda.entities.association.functionnality;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RentingType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private ConfigType configType;
	
	private String nameRentingType;

	public ConfigType getConfigType() {
		return configType;
	}

	public void setConfigType(ConfigType configType) {
		this.configType = configType;
	}

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
