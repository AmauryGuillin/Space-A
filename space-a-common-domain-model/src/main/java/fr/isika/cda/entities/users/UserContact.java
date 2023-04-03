package fr.isika.cda.entities.users;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.isika.cda.entities.common.Address;
import fr.isika.cda.entities.common.Phone;

@Entity
@Table(name = "user_contact")
public class UserContact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6242389040669315536L;

	@Id
	@GeneratedValue
	private Long id;

	private String primaryEmail;
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
	private Address address;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "countryCode", column = @Column(name = "uc_phone_countryCode")),
		@AttributeOverride(name = "phoneNumber", column = @Column(name = "uc_phone_phoneNumber")),
	})
	private Phone phone;
	
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
	
}
