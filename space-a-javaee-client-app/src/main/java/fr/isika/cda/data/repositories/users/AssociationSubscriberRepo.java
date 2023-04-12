package fr.isika.cda.data.repositories.users;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.isika.cda.entities.users.AssociationSubscriber;
import fr.isika.cda.entities.users.UserAccount;

@Stateless
public class AssociationSubscriberRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	private UserAccount userAccount;


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
	
	public List<Long> listOfMemberIdOfAsso(Long assocId) {
		List<Long> listAllMembers = new ArrayList<Long>();
//		Query query = entityManager.createQuery("SELECT ASSOCIATIONSUBSCRIBER_ID FROM ASSOCIATION_SUBSCRIBER WHERE ASSOCIATION_ID = :assocId");
//        
//		query.setParameter("assocId", assocId);
//		listAllMembers = query.getResultList();

		listAllMembers = new ArrayList<Long>();
		listAllMembers.add(1L);
		listAllMembers.add(2L);
		listAllMembers.add(3L);

		System.out.println("*********************** liste membre " + listAllMembers);
		return listAllMembers;
	}
	
	
}
