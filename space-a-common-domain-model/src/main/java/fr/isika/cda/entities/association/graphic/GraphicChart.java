package fr.isika.cda.entities.association.graphic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="graphic_chart")
public class GraphicChart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String mainColor;
	
	private String secondaryColor;
	
	private String tertiaryColor;
	
	private String font;
	
	private String banner;
	
	public String getMainColor() {
		return mainColor;
	}

	public void setMainColor(String mainColor) {
		this.mainColor = mainColor;
	}

	public String getSecondaryColor() {
		return secondaryColor;
	}

	public void setSecondaryColor(String secondaryColor) {
		this.secondaryColor = secondaryColor;
	}

	public String getTertiaryColor() {
		return tertiaryColor;
	}

	public void setTertiaryColor(String tertiaryColor) {
		this.tertiaryColor = tertiaryColor;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public Long getId() {
		return id;
	}

	
	

	
}
