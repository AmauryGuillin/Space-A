package fr.isika.cda.entities.association;

public enum Template {

	CLASSIC("Template classique"), OLD("Skyblog 2002"), MODERN("Futurama");

	private final String label;

	private Template(final String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	
	
}
