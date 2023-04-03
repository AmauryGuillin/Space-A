package fr.isika.cda.entities.users;

public enum UserRole {

	VISITOR ("Unregistred user"), USER("Regitered User"), MEMBER("Member"), ADMIN("Administrator");

	private final String label;

	private UserRole(final String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
