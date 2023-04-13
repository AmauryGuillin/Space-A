package fr.isika.cda.entities.association.functionnality;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConfigType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
