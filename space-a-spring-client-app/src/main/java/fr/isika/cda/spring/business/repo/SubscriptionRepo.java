package fr.isika.cda.spring.business.repo;

import org.springframework.data.repository.CrudRepository;

import fr.isika.cda.entities.association.subscriptions.AssoAdminSubscription;

public interface SubscriptionRepo extends CrudRepository<AssoAdminSubscription, Long>{

	//----> Possible rajout de méthodes custom ICI <----
}
