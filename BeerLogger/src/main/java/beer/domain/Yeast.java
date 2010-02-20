package beer.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;

@Entity
//@Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_ONLY)
public class Yeast implements Comparable<Yeast> {

	private int id;
	@Id 
	@GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	private String style;
	public String getStyle() {return style;}
	public void setStyle(String style) {this.style = style;};
	
	private String lab;
	public String getLab() {return lab;}
	public void setLab(String lab) {this.lab = lab;}
	
	private String floculation;
	public String getFloculation() {return floculation;}
	public void setFloculation(String flocualtion) {this.floculation = flocualtion;}
	
	private String attenuation;
	public String getAttenuation() {return attenuation;}
	public void setAttenuation(String attenuation) {this.attenuation = attenuation;}
	
	private String temp;
	public String getTemp() {return temp;}
	public void setTemp(String temp) {this.temp = temp;}
	
	private String description;
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
	private List<YeastIngredient> yeastIngredients;
	@OneToMany(mappedBy="yeast")
	public List<YeastIngredient> getYeastIngredients() { return yeastIngredients; }
	public void setYeastIngredients(List<YeastIngredient> yeastIngredients) { this.yeastIngredients = yeastIngredients; }
	
	public int compareTo(Yeast y) {
		return name.compareTo(y.getName());
	}
}
