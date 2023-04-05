package fr.isika.cda.data.repositories.users;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.entities.users.UserAccount;

@Stateless
public class AccountRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Long createAccount(UserAccount account) {
		entityManager.persist(account);
		return account.getUserId();
	}

	
	
	
	//Getters & Setters
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	

}
