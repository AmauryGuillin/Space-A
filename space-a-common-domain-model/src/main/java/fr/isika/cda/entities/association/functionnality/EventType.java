package fr.isika.cda.entities.association.functionnality;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EventType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private ConfigType configType;
	
	private String nameEventType;

	public ConfigType getConfigType() {
		return configType;
	}

	public void setConfigType(ConfigType configType) {
		this.configType = configType;
	}

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
