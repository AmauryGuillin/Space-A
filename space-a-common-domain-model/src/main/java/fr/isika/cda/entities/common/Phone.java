package fr.isika.cda.entities.common;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2144622742198772175L;

	private final String counrtyCode;
	private final String phoneNumber;

	public Phone(final String counrtyCode, final String phoneNumber) {
		this.counrtyCode = counrtyCode;
		this.phoneNumber = phoneNumber;
	}

	public String getCounrtyCode() {
		return counrtyCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
}
