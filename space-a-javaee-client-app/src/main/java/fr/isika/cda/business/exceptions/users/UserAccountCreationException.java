package fr.isika.cda.business.exceptions.users;

public class UserAccountCreationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1177394303977337828L;

	public UserAccountCreationException() {
		super();
	}

	public UserAccountCreationException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAccountCreationException(String message) {
		super(message);
	}

	public UserAccountCreationException(Throwable cause) {
		super(cause);
	}
	
}
