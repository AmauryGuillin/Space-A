package fr.isika.cda.data.repositories.association;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.functionnality.ConfigType;
import fr.isika.cda.entities.association.functionnality.EventType;

@Stateless
public class AssociationRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Long createAsso(Association association) {
		entityManager.persist(association);
		return association.getId();
	}
	
	public List<Association> findAll(){
		return entityManager.createQuery("SELECT a FROM Association a", Association.class).getResultList();
	}
	
	public Association findOneById(Long id) {
		TypedQuery<Association> query = entityManager.createQuery("SELECT a FROM Association a WHERE a.id = :id", Association.class);
	    query.setParameter("id", id);
	    return query.getSingleResult();
	}

	public Long majAsso(Association asso) {
		Association mergedAsso = entityManager.merge(asso);
	    entityManager.flush();
	    return mergedAsso.getId();
		
	}

	public void addEventToAsso(Association asso, EventType event) {
//		Association assoWithEvents = entityManager.createQuery(
//				"SELECT a FROM Association a, AssociationFonctionnality af, ConfigType c, EventType e JOIN FETCH a.af.c.events WHERE a.id =:assoIdParam",
//				Association.class).setParameter("associationFunctionnality", asso.getId()).getSingleResult();
		
		
		ConfigType config = entityManager.createQuery(
				"SELECT c, a FROM ConfigType c, Association a LEFT JOIN FETCH c.events WHERE a.id =:assoIdParam", ConfigType.class)
				.setParameter("assoIdParam", asso.getId())
				.getSingleResult();
		
		config.addEventType(event);
		entityManager.persist(event);
		entityManager.merge(config);
	}
	
}
