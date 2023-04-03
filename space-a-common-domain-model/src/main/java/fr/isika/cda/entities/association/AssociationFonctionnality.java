package fr.isika.cda.entities.association;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Association_Fonctionnality")
public class AssociationFonctionnality {
	
	@Id
	@GeneratedValue
	private Long id;
	
//	@OneToOne
//	private AssociationSubscriberControl associationSubscriberControl;
//	
//	@OneToOne
//	private AssociationSubscriberPayment associationSubscriberPayment;
	
	@OneToOne
	private ConfigType configType;
	
}
