package fr.isika.cda.data.repositories;

import java.util.List;
import java.util.Optional;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericRepository<I, T> {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Inject
    private Event<T> eventSrc;
	
	public abstract Optional<T> findById(I id);
	public abstract List<T> findAll();
	
	public void create(T entity) {
		entityManager.persist(entity);
		eventSrc.fire(entity);
	}
	
}
