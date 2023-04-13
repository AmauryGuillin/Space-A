package fr.isika.cda.entities.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.subscriptions.Subscription;
import fr.isika.cda.entities.users.plannings.AccountPlanning;

@Entity
@Table(name = "user_account")
@NamedQuery(name = UserAccount.Queries.FINDALL_NAMED_QUERY, query = "FROM UserAccount acc")
@NamedQuery(name = UserAccount.Queries.FINDBY_USERID_NAMED_QUERY, query = "FROM UserAccount acc WHERE acc.userId =: "
		+ UserAccount.Queries.USERID_QUERY_PARAM)
@NamedQuery(name = UserAccount.Queries.FINDBY_USERNAME_NAMED_QUERY, query = "FROM UserAccount acc WHERE acc.username =: "
		+ UserAccount.Queries.USERNAME_QUERY_PARAM)
public class UserAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8632944335273962858L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private Long selectedAssociation;

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

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) // for the admin
	private Association association;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "subscription_id")
	private List<Subscription> subscriptions = new ArrayList<>();

	/*
	 * Public methods
	 */
	/**
	 * Réalise la double association UserAccount <--> Subscription
	 * @param subscription
	 * @return
	 */
	public boolean addSubscription(final Subscription subscription) {
		subscription.setAccount(this);
		return this.subscriptions.add(subscription);
	}
	public boolean removeSubscription(final Subscription subscription) {
		return this.subscriptions.remove(subscription);
	}
	public boolean hasSubscriptions() {
		return !subscriptions.isEmpty();
	}
	public void updateUserRole(final UserRole newRole) {
		this.primaryRole = newRole;
	}
	public boolean isAdmin() {
		return primaryRole.equals("ADMIN");
	}
	/*
	 * Getters
	 */
	public Long getUserId() {
		return userId;
	}

	public AccountPlanning getAccountPlanning() {
		return accountPlanning;
	}

	public Association getAssociation() {
		return association;
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

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public UserRole getPrimaryRole() {
		return primaryRole;
	}

	public Long getSelectedAssociation() {
		return selectedAssociation;
	}

	public void updateSelectedAssociation(Long selectedAssociation) {
		this.selectedAssociation = selectedAssociation;
	}
	
	/*
	 * Builder methods
	 */
	
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

	public UserAccount withAssociation(final Association association) {
		this.association = association;
		return this;
	}

	public UserAccount withAccountPlanning(final AccountPlanning accountPlanning) {
		this.accountPlanning = accountPlanning;
		return this;
	}

	public UserAccount withDefaultPropertiesAndProfile() {
		this.username = DefaultValues.DEFAULT_USERNAME;
		this.password = DefaultValues.DEFAULT_PASSWORD;
		this.userProfile = new UserProfile();
		return this;
	}

	public UserAccount withSelectedAssociation(long selectedAssociationId) {
		selectedAssociation = selectedAssociationId;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserAccount [userId=");
		builder.append(userId);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", primaryRole=");
		builder.append(primaryRole);
		builder.append(", userProfile=");
		builder.append(userProfile);
		builder.append(", accountPlanning=");
		builder.append(accountPlanning);
		builder.append(", association=");
		builder.append(association);
		builder.append(", selectedAssociation=");
		builder.append(selectedAssociation);
		builder.append("]");
		return builder.toString();
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
