package fr.isika.cda.entities.association;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "association_depiction")
public class AssociationDepiction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="commercial_name", length = 50, nullable = false)
    private String name;
	
	@Column(length = 2000, nullable = true)
    private String description;
	
	@Column(nullable = true)
    private String logo;
	
	@Column(nullable = true)
    private String mainImage;
    
    @OneToMany
    private List<AlbumImage> album = new ArrayList<>();
    
    
    // Getters and setters for attributes except set ID
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getLogo() {
        return logo;
    }
    
    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    public String getMainImage() {
        return mainImage;
    }
    
    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public List<AlbumImage> getAlbum() {
		return Collections.unmodifiableList(album);
	}
    
    public boolean addImage(final AlbumImage albumImage) {
    	return this.album.add(albumImage);
    }
}
