package fr.isika.cda.data.repositories.users;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import fr.isika.cda.business.exceptions.users.UserNotFoundException;
import fr.isika.cda.data.repositories.GenericRepository;
import fr.isika.cda.entities.association.subscriptions.Subscription;
import fr.isika.cda.entities.users.UserAccount;

@Stateless
public class UserAccountRepository extends GenericRepository<Long, UserAccount> {

	public Long createAccount(UserAccount account) {
		entityManager.persist(account);
		return account.getUserId();
	}

	// @formatter:off
	@Override
	public Optional<UserAccount> findById(Long id) {
		UserAccount userAccount = entityManager
				.createNamedQuery(UserAccount.Queries.FINDBY_USERID_NAMED_QUERY, UserAccount.class)
				.setParameter(UserAccount.Queries.USERID_QUERY_PARAM, id)
				.getSingleResult();
		return Optional.ofNullable(userAccount);
	}
	// @formatter:on
	
	public UserAccount findByOneId(Long id) {
		return entityManager
				.createNamedQuery(UserAccount.Queries.FINDBY_USERID_NAMED_QUERY, UserAccount.class)
				.setParameter(UserAccount.Queries.USERID_QUERY_PARAM, id)
				.getSingleResult();
	}

	public UserAccount findByOneIdWithSubscriptions(Long id) {
		return entityManager
				.createQuery("SELECT u FROM UserAccount u LEFT JOIN FETCH u.subscriptions WHERE u.id=:userAccountIdParam", UserAccount.class)
				.setParameter("userAccountIdParam", id)
				.getSingleResult();
	}
	
	@Override
	public List<UserAccount> findAll() {
		return entityManager
				.createNamedQuery(UserAccount.Queries.FINDALL_NAMED_QUERY, UserAccount.class)
				.getResultList();
	}

	public Optional<UserAccount> findByUsername(final String username) throws UserNotFoundException {
		try {
			return Optional.ofNullable(findByOneName(username));
		} catch (NoResultException e) {
			throw new UserNotFoundException(String.format("No user with username : %s", username), e);
		}
	}

	public UserAccount findByOneName(final String userName) {
		return entityManager
				.createNamedQuery(UserAccount.Queries.FINDBY_USERNAME_NAMED_QUERY, UserAccount.class)
				.setParameter(UserAccount.Queries.USERNAME_QUERY_PARAM, userName)
				.getSingleResult();	
	}

	public UserAccount createUserAccount(UserAccount userAccount) {
		entityManager.persist(userAccount);
		return userAccount;
	}
	
	public Long majProfile(UserAccount account) {
	    UserAccount mergedAccount = entityManager.merge(account);
	    entityManager.flush();
	    return mergedAccount.getUserId();
	}


	public void remove(Long idToDelete) {
		UserAccount userAccount = entityManager
				.createNamedQuery(UserAccount.Queries.FINDBY_USERID_NAMED_QUERY, UserAccount.class)
				.setParameter(UserAccount.Queries.USERID_QUERY_PARAM, idToDelete)
				.getSingleResult();
		entityManager.remove(userAccount);
	}


	public UserAccount updateUserFromAsso(UserAccount userConnecte) {
		return entityManager.merge(userConnecte);
	}

	public List<Subscription> findUserSubscriptions(Long userId) {
		return entityManager
				.createQuery("SELECT s FROM Subscription s WHERE s.account.id =: userAccountIdParam", Subscription.class)
				.setParameter("userAccountIdParam", userId)
				.getResultList();
	}

}
