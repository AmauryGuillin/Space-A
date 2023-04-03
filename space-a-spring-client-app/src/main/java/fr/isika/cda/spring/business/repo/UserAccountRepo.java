package fr.isika.cda.spring.business.repo;

import org.springframework.data.repository.CrudRepository;

import fr.isika.cda.entities.users.UserAccount;

public interface UserAccountRepo extends CrudRepository<UserAccount, Long> {
}