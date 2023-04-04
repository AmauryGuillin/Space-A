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
		return entityManager.createQuery("SELECT a FROM Association a").getResultList();
	}
	
	public Association findOneById(Long id) {
		TypedQuery<Association> query = entityManager.createQuery("SELECT a FROM Association a WHERE a.id = :id", Association.class);
	    query.setParameter("id", id);
	    return query.getSingleResult();
	}

	@Override
	public String toString() {
		return "AssociationRepository [entityManager=" + entityManager + "]";
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
}
