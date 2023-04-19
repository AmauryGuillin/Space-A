package fr.isika.cda.entities.association.functionnality;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Association_Fonctionnality")
public class AssociationFunctionnality {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private AssociationSubscriberControl associationSubscriberControl;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private AssociationSubscriberPayment associationSubscriberPayment;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private ConfigType configType;

	public AssociationSubscriberControl getAssociationSubscriberControl() {
		return associationSubscriberControl;
	}

	public void setAssociationSubscriberControl(AssociationSubscriberControl associationSubscriberControl) {
		this.associationSubscriberControl = associationSubscriberControl;
	}

	public AssociationSubscriberPayment getAssociationSubscriberPayment() {
		return associationSubscriberPayment;
	}

	public void setAssociationSubscriberPayment(AssociationSubscriberPayment associationSubscriberPayment) {
		this.associationSubscriberPayment = associationSubscriberPayment;
	}

	public ConfigType getConfigType() {
		return configType;
	}

	public void setConfigType(ConfigType configType) {
		this.configType = configType;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
