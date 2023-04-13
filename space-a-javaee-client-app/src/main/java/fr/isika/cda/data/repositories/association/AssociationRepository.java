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

	private static final String CONFIG_TYPE_WITH_EVTS_BY_ID = "SELECT c FROM ConfigType c LEFT JOIN FETCH c.events WHERE c.id =:configTypeIdParam";
	
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

	public List<EventType> getAllEventsByConfigTypeId(Long configTypeId) {
		return getConfigTypeWithEvtsById(configTypeId).getEvents();
	}
	
	public void addEventToAsso(Long configTypeId, EventType event) {
		ConfigType configWithEvents = getConfigTypeWithEvtsById(configTypeId);
		configWithEvents.addEventType(event);
		entityManager.persist(event);
		entityManager.merge(configWithEvents);
	}

	private ConfigType getConfigTypeWithEvtsById(Long configTypeId) {
		return entityManager.createQuery(
				CONFIG_TYPE_WITH_EVTS_BY_ID, ConfigType.class)
				.setParameter("configTypeIdParam", configTypeId)
				.getSingleResult();
	}
	
	
	
}
