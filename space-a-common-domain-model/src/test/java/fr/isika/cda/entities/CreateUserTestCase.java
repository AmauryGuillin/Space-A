package fr.isika.cda.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserProfile;

class CreateUserTestCase {

	@Test
	void createDefaultUser() throws Exception {
		
		UserAccount defaultUser = new UserAccount()
				.withDefaultPropertiesAndProfile();
		
		assertNotNull(defaultUser, "Should create a non-null user object with username('user') and password('user'), by default");
		assertEquals("user", defaultUser.getUsername());
		assertEquals("password", defaultUser.getPassword());
		
		UserProfile profile = defaultUser.getUserProfile();
		assertNotNull(profile, "User created by default should have a non-null profile object");
		
		assertTrue(profile.getFirstName().isEmpty());
		assertTrue(profile.getLastName().isEmpty());
		assertTrue(profile.getAvatar().isEmpty());
		
		assertNull(profile.getUserContact(), "User created by default does not have a contact object by default");
	}
	
	@Test
	void createUserWithGivenProperties() throws Exception {
		
		UserAccount actual = new UserAccount()
				.withUsername("test")
				.withPassword("123")
				.withProfile(new UserProfile()
						.withFirstName("myFirstName")
						.withLastName("myLastName")
						.withAvatar("myAvatar.png"));
		
		assertNotNull(actual, "Should create a non-null user object with given properties");
		assertEquals("test", actual.getUsername());
		assertEquals("123", actual.getPassword());
		
		UserProfile profile = actual.getUserProfile();
		assertNotNull(profile, "User created by default should have a non-null profile object");
		
		assertEquals("myFirstName", profile.getFirstName());
		assertEquals("myLastName", profile.getLastName());
		assertEquals("myAvatar.png", profile.getAvatar());
		
		assertNull(profile.getUserContact(), "User created by default does not have a contact object by default");
	}

}
