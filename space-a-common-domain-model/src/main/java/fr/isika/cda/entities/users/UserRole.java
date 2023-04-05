package fr.isika.cda.entities.users;

public enum UserRole {

	VISITOR ("visiteur"), USER("utilisateur"), MEMBER("Membre"), ADMIN("Administrateur");

	private final String label;

	private UserRole(final String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
