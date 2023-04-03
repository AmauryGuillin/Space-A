package fr.isika.cda.entities.association;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ConfigType {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated
	private EventType eventType;
	
	@Enumerated
	private PublicationType publicationType;
	
	@Enumerated
	private ActivityType activityType;
	
	@Enumerated
	private RentingType rentingType;

}
