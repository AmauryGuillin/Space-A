package fr.isika.cda.entities.users;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.isika.cda.entities.common.Address;
import fr.isika.cda.entities.common.Phone;

@Entity
@Table(name = "user_contact")
public class UserContact implements Serializable {

	@Override
	public String toString() {
		return "UserContact [id=" + id + ", primaryEmail=" + primaryEmail + ", secondaryEmail=" + secondaryEmail
				+ ", address=" + address + ", phone=" + phone + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6242389040669315536L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, nullable = false, unique = true)
	private String primaryEmail;
	
	@Column(length = 50, nullable = true, unique = true)
	private String secondaryEmail;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "lineOne", column = @Column(name = "uc_address_lineOne")),
		@AttributeOverride(name = "lineTwe", column = @Column(name = "uc_address_lineTwo")),
		@AttributeOverride(name = "zipCode", column = @Column(name = "uc_address_zipCode")),
		@AttributeOverride(name = "city", column = @Column(name = "uc_address_city")),
		@AttributeOverride(name = "state", column = @Column(name = "uc_address_state")),
		@AttributeOverride(name = "country", column = @Column(name = "uc_address_country"))
	})
	
	private Address address = new Address();
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "countryCode", column = @Column(name = "uc_phone_countryCode")),
		@AttributeOverride(name = "phoneNumber", column = @Column(name = "uc_phone_phoneNumber")),
	})
	
	//@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Phone phone = new Phone();
	
	public Long getId() {
		return id;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public Address getAddress() {
		return address;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	public class Queries {
		public static final String FINDALL_CONTACT_QUERY = "UserContact.findAll";

		public static final String FINDBY_CONTACT_PRIMARYEMAIL_QUERY = "UserContact.findByPrimaryEmail";
		
		private Queries() {
		}
	
	}
}
