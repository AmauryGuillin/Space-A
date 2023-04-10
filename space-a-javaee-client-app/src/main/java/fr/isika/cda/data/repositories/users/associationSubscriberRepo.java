package fr.isika.cda.data.repositories.users;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.isika.cda.entities.users.AssociationSubscriber;

@Stateless
public class associationSubscriberRepo {

	@PersistenceContext
	private EntityManager entityManager;

	public AssociationSubscriber findById(Long id) {
	    AssociationSubscriber associationSubscriber = null;
	    try {
	        TypedQuery<AssociationSubscriber> query = entityManager.createQuery("SELECT a FROM AssociationSubscriber a WHERE a.association.id = :id", AssociationSubscriber.class);
	        query.setParameter("id", id);
	        associationSubscriber = query.getSingleResult();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return associationSubscriber;
	}
	
	
}
