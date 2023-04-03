package fr.isika.cda.entities.assoService;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import fr.isika.cda.entities.association.Association;

@Entity
public class Publication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	
	private String description;
	
	private String author;
	
	private String imagePath;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Association association;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public long getId() {
		return id;
	}
	
	// ajouter l'enum publicationType
	
}
