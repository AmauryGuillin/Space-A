package fr.isika.cda.entities.association.functionnality;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Association_Fonctionnality")
public class AssociationFunctionnality {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private AssociationSubscriberControl associationSubscriberControl;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private AssociationSubscriberPayment associationSubscriberPayment;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private ConfigType configType;
	
}
