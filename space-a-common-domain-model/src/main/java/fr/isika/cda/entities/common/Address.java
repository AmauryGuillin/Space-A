package fr.isika.cda.entities.common;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6200773657260155980L;

	private String lineOne;
	private String lineTwo;

	private String zipCode;

	private String city;

	private String state;
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
