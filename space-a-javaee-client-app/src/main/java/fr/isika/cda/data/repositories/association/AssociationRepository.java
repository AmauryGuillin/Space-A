package fr.isika.cda.data.repositories.association;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.isika.cda.entities.association.Association;

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
	
}
