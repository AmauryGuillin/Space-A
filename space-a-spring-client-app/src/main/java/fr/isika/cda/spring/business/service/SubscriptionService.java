package fr.isika.cda.spring.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.isika.cda.entities.association.subscriptions.AssoAdminSubscription;
import fr.isika.cda.spring.AppCollectionUtils;
import fr.isika.cda.spring.business.repo.SubscriptionRepo;

@Service
@Transactional
public class SubscriptionService {
	
	@Autowired
	private SubscriptionRepo repo;
	
	public Optional<AssoAdminSubscription> byId(final Long id){
		return repo.findById(id);
	}
	
	public void remove(final Long id) {
		repo.deleteById(id);
	}
	
	public List<AssoAdminSubscription> all(){
		return AppCollectionUtils.asList(repo.findAll());
	}

	public void save(AssoAdminSubscription subscription) {
		repo.save(subscription);
	}
	


}
