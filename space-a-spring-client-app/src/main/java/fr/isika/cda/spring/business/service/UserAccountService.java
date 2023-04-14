package fr.isika.cda.spring.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.spring.AppCollectionUtils;
import fr.isika.cda.spring.business.repo.UserAccountRepo;

@Service
@Transactional
public class UserAccountService /*implements InitializingBean*/ {

	@Autowired
	private UserAccountRepo repo;

	//@formatter:off
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		
//		UserAccount account = new UserAccount()
//				.withUsername("test")
//				.withPassword("test")
//				.withProfile(new UserProfile()
//						.withFirstName("Mo")
//						.withLastName("BH"));
//		
//		repo.save(account);
//	}
	//@formatter:on

	public Optional<UserAccount> byId(final Long id) {
		return repo.findById(id);
	}
	
	public void remove(final Long id) {
		repo.deleteById(id);
	}

	public List<UserAccount> all() {
		return AppCollectionUtils.asList(repo.findAll());
	}


}