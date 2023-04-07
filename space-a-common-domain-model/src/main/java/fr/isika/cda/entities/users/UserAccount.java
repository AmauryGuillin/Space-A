package fr.isika.cda.entities.users;

import java.io.Serializable; 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.isika.cda.entities.association.Association;

@Entity
@Table(name = "user_account")
@NamedQuery(name = UserAccount.Queries.FINDALL_NAMED_QUERY, query = "FROM UserAccount acc")
@NamedQuery(name = UserAccount.Queries.FINDBY_USERID_NAMED_QUERY, query = "FROM UserAccount acc WHERE acc.userId =: " + UserAccount.Queries.USERID_QUERY_PARAM)
@NamedQuery(name = UserAccount.Queries.FINDBY_USERNAME_NAMED_QUERY, query = "FROM UserAccount acc WHERE acc.username =: " + UserAccount.Queries.USERNAME_QUERY_PARAM)
public class UserAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8632944335273962858L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(length = 20, nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	private UserRole primaryRole;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private UserProfile userProfile = new UserProfile();
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private AccountPlanning accountPlanning;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Association association;
	
	
	
	
	
	

	@Override
	public String toString() {
		return "UserAccount [userId=" + userId + ", username=" + username + ", password=" + password + ", primaryRole="
				+ primaryRole + ", userProfile=" + userProfile + ", accountPlanning=" + accountPlanning
				+ ", association=" + association + "]";
	}

	public Long getUserId() {
		return userId;
	}

	public AccountPlanning getAccountPlanning() {
		return accountPlanning;
	}

	public void setAccountPlanning(AccountPlanning accountPlanning) {
		this.accountPlanning = accountPlanning;
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public UserRole getPrimaryRole() {
		return primaryRole;
	}
	public void setPrimaryRole(UserRole primaryRole) {
		this.primaryRole = primaryRole;
	}
	
	public UserAccount withUsername(String username) {
		this.username = username;
		return this;
	}

	public UserAccount withPassword(String password) {
		this.password = password;
		return this;
	}

	public UserAccount withProfile(UserProfile profile) {
		userProfile = profile;
		return this;
	}

	public UserAccount withPrimaryRole(UserRole role) {
		primaryRole = role;
		return this;
	}

	public UserAccount withDefaultPropertiesAndProfile() {
		this.username = DefaultValues.DEFAULT_USERNAME;
		this.password = DefaultValues.DEFAULT_PASSWORD;
		this.userProfile = new UserProfile();
		return this;
	}
	
	class DefaultValues {
		public static final String DEFAULT_USERNAME = "user";
		public static final String DEFAULT_PASSWORD = "password";
		private DefaultValues() {
		}
	}
	
	public class Queries {
		public static final String FINDALL_NAMED_QUERY = "UserAccount.findAll";

		public static final String FINDBY_USERNAME_NAMED_QUERY = "UserAccount.findByUsername";
		public static final String FINDBY_USERID_NAMED_QUERY = "UserAccount.findByUserId";

		public static final String USERID_QUERY_PARAM = "userIdQueryParam";
		public static final String USERNAME_QUERY_PARAM = "userNameQueryParam";
		
		private Queries() {
		}
	}
}
