package fr.isika.cda.data.repositories.association;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.isika.cda.entities.association.subscriptions.AssoAdminSubscription;

@Stateless
public class AssoAdminSubscriptionRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Long createSubscription(AssoAdminSubscription assoSub) {
		entityManager.persist(assoSub);
		return assoSub.getId();
	}
	
	public List<AssoAdminSubscription> findAll() {
		return entityManager.createQuery("SELECT a FROM assoadminsubscription a", AssoAdminSubscription.class).getResultList();
	}
	
	public AssoAdminSubscription findAssoSubById(Long idsub) {
		TypedQuery<AssoAdminSubscription> query = entityManager.createQuery("SELECT a FROM AssoAdminSubscription a WHERE a.id =: id",
				AssoAdminSubscription.class);
		query.setParameter("id", idsub);
		return query.getSingleResult();
	}

}
