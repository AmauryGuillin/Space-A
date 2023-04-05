package fr.isika.cda.entities.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6200773657260155980L;

	@Column(length = 255, nullable = true, unique = false)
	private String lineOne;
	
	@Column(length = 255,nullable = true, unique = false)
	private String lineTwo;
	
	@Column(length = 10,nullable = true, unique = false)
	private String zipCode;
	
	@Column(length = 50, nullable = true, unique = false)
	private String city;
	
	@Column(length = 50, nullable = true, unique = false)
	private String state;
	
	@Column(length = 50, nullable = true, unique = false)
	private String country;

	/**
	 * Creates a default instance of {@link Address} with null properties.
	 * 
	 * @return
	 */
	public Address createEmpty() {
		return new Address();
	}

	/**
	 * Creates a generic instance of {@link Address} with the given properties.
	 * 
	 * @param lineOne
	 * @param zipCode
	 * @param city
	 * @param counrty
	 * @return
	 */
	public Address create(final String lineOne, final String zipCode, final String city, final String counrty) {
		return create(lineOne, "", zipCode, city, "", counrty);
	}

	/**
	 * Creates a detailed instance of {@link Address} with the given properties.
	 * 
	 * @param lineOne
	 * @param lineTwo
	 * @param zipCode
	 * @param city
	 * @param state
	 * @param country
	 * @return
	 */
	Address create(final String lineOne, final String lineTwo, final String zipCode, final String city,
			final String state, final String country) {
		Address address = new Address();
		address.lineOne = lineOne;
		address.lineTwo = lineTwo;
		address.zipCode = zipCode;
		address.city = city;
		address.state = state;
		address.country = country;
		return address;
	}

	public String getLineOne() {
		return lineOne;
	}

	public String getLineTwo() {
		return lineTwo;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

}
