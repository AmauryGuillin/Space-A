package fr.isika.cda.entities.association.subscriptions;

public enum AdminPaymentStatus {
	
	VALIDATED ("Validé"), PENDING("En attente"), IN_DELAY("En retard"),;

	private final String label;

	private AdminPaymentStatus(final String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
