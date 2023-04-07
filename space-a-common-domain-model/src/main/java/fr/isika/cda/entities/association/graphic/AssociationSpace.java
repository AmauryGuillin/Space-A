package fr.isika.cda.entities.association.graphic;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="assiociation_space")
public class AssociationSpace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Template template;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private GraphicChart graphicChart;

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public Long getId() {
		return id;
	}

	public GraphicChart getGraphicChart() {
		return graphicChart;
	}

	public void setGraphicChart(GraphicChart graphicChart) {
		this.graphicChart = graphicChart;
	} 

	
	
	
	
}
