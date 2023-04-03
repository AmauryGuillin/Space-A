package fr.isika.cda.entities.association;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assiociation_space")
public class AssociationSpace {

	@Id
	@GeneratedValue
	private Long id;
	
	private Template template;
	
	
	//private GraphicChart graphicChart;

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public Long getId() {
		return id;
	} 

	
	
	
	
}
