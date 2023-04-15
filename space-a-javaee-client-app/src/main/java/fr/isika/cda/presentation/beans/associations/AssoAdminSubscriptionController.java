package fr.isika.cda.presentation.beans.associations;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssoAdminSubscriptionRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.functionnality.AssociationSubscriberPayment;
import fr.isika.cda.entities.association.subscriptions.AssoAdminSubscription;

@ManagedBean
public class AssoAdminSubscriptionController {
	
	AssoAdminSubscription assoAS;
	
	@Inject
	private AssoAdminSubscriptionRepository assoAdminRepo;
	
	
	public AssoAdminSubscription getAdminSubDetails() {
		assoAS = assoAdminRepo.findAssoSubById(1L);
		return assoAS;
	}
	
	
	

	

}
