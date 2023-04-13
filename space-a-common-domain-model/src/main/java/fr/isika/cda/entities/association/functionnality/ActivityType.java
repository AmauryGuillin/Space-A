package fr.isika.cda.entities.association.functionnality;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ActivityType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private ConfigType configType;
	
	private String nameActivityType;

	public ConfigType getConfigType() {
		return configType;
	}

	public void setConfigType(ConfigType configType) {
		this.configType = configType;
	}

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
