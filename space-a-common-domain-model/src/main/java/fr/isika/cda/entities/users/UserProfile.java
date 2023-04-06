package fr.isika.cda.entities.users;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 244166025066426404L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = true, unique = false)
	private String firstName = "";
	
	@Column(length = 50, nullable = true, unique = false)
	private String lastName = "";
	
	@Column(nullable = true)
	private String avatar = "";
	
	@Temporal (TemporalType.DATE)
	private Date birthday = new Date();
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private UserContact userContact;


	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public UserContact getUserContact() {
		return userContact;
	}

	public void setUserContact(UserContact userContact) {
		this.userContact = userContact;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserProfile withFirstName(final String firstName) {
		this.firstName = firstName;
		return this;
	}

	public UserProfile withLastName(final String lastName) {
		this.lastName = lastName;
		return this;
	}

	public UserProfile withAvatar(final String avatar) {
		this.avatar = avatar;
		return this;
	}

	public UserProfile withContact(final UserContact contact) {
		this.userContact = contact;
		return this;
	}
}
