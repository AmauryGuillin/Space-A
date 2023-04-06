package fr.isika.cda.data.repositories.users;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.isika.cda.business.exceptions.users.UserNotFoundException;
import fr.isika.cda.data.repositories.GenericRepository;
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserContact;
import fr.isika.cda.entities.users.UserRole;

@Stateless
public class UserAccountRepository extends GenericRepository<Long, UserAccount> {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Long createAccount(UserAccount account) {
		entityManager.persist(account);
		return account.getUserId();
	}
	

	@Override
	public Optional<UserAccount> findById(Long id) {
		UserAccount userAccount = entityManager
				.createNamedQuery(UserAccount.Queries.FINDBY_USERID_NAMED_QUERY, UserAccount.class)
				.setParameter(UserAccount.Queries.USERID_QUERY_PARAM, id)
				.getSingleResult();
		return Optional.ofNullable(userAccount);
	}
	
	public UserAccount findByOneId(Long id) {
		UserAccount userAccount = entityManager
				.createNamedQuery(UserAccount.Queries.FINDBY_USERID_NAMED_QUERY, UserAccount.class)
				.setParameter(UserAccount.Queries.USERID_QUERY_PARAM, id)
				.getSingleResult();
		return userAccount;
	}

	@Override
	public List<UserAccount> findAll() {
		return entityManager
				.createNamedQuery(UserAccount.Queries.FINDALL_NAMED_QUERY, UserAccount.class)
				.getResultList();
	}

	public Optional<UserAccount> findByUsername(final String username) throws UserNotFoundException {
		try {
			UserAccount account = entityManager
					.createNamedQuery(UserAccount.Queries.FINDBY_USERNAME_NAMED_QUERY, UserAccount.class)
					.setParameter(UserAccount.Queries.USERNAME_QUERY_PARAM, username)
					.getSingleResult();
			
			return Optional.ofNullable(account);
		} catch (NoResultException e) {
			throw new UserNotFoundException(String.format("No user with username : %s", username), e);
		}
	}

	public UserAccount findByOneName(String userName) {
		UserAccount userAccount = entityManager
				.createNamedQuery(UserAccount.Queries.FINDBY_USERNAME_NAMED_QUERY, UserAccount.class)
				.setParameter(UserAccount.Queries.USERNAME_QUERY_PARAM, userName)
				.getSingleResult();
		return userAccount;	
		}
	

	public UserAccount createUserAccount(UserAccount userAccount) {
		entityManager.persist(userAccount);
		return userAccount;
	}
	
	public Long majProfile(UserAccount account) {
		entityManager.persist(account);
		return account.getUserId();
	}

}
