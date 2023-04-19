package fr.isika.cda.data.repositories.users;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;

import fr.isika.cda.data.repositories.GenericRepository;
import fr.isika.cda.entities.association.subscriptions.Subscription;

@Stateless
public class SubscriptionsRepository extends GenericRepository<Long, Subscription> {

	@Override
	public Optional<Subscription> findById(Long id) {
		return Optional.ofNullable(
				entityManager.createQuery("SELECT s FROM Subscription s WHERE s.id = :id", Subscription.class)
						.setParameter("id", id)
						.getSingleResult());
	}

	public List<Subscription> findSubscriptionsOfAssociation(Long assoId) {
		return entityManager
				.createQuery("SELECT s FROM Subscription s WHERE s.association.id = :assoIdParam", Subscription.class)
				.setParameter("assoIdParam", assoId)
				.getResultList();
	}

	@Override
	public List<Subscription> findAll() {
		return entityManager.createQuery("SELECT s FROM Subscription s", Subscription.class).getResultList();
	}

}
