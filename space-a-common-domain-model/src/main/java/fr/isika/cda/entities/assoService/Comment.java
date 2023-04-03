package fr.isika.cda.entities.assoService;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import fr.isika.cda.entities.association.Association;

@Entity
public class Comment {

	
		@Id
		@GeneratedValue	
		private long id;
		
		private String title;
		
		private String description;
		
		private String author;
		
		private String imagePath;
		
		private String Content;
		
		@ManyToOne(cascade = CascadeType.ALL)
		private Publication publication;

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

		public String getContent() {
			return Content;
		}

		public void setContent(String content) {
			Content = content;
		}

		public void setId(long id) {
			this.id = id;
		}
		
}
