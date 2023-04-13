package fr.isika.cda.entities.association.functionnality;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PublicationType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private ConfigType configType;
	
	private String namePublicationType;

	public ConfigType getConfigType() {
		return configType;
	}

	public void setConfigType(ConfigType configType) {
		this.configType = configType;
	}

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
