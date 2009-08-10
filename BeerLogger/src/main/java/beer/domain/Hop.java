package beer.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Hop implements Comparable<Hop> {
	
	private int id;
	@Id @GeneratedValue
	public int getId() { return id; }
	public void setId(int id) {this.id = id;}
	
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	private double alpha;
	public double getAlpha() {return alpha;}
	public void setAlpha(double alpha) {this.alpha = alpha;}
	
	private String description;
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
	private List<Hop> substitutions;
	@ManyToMany
	public List<Hop> getSubstitutions() { return substitutions; }
	public void setSubstitutions(List<Hop> substitutions) { this.substitutions = substitutions; }
	
	private List<HopIngredient> hopIngredients;
	@OneToMany(mappedBy="hop")
	public List<HopIngredient> getHopIngredients() { return hopIngredients; }
	public void setHopIngredients(List<HopIngredient> hopIngredients) { this.hopIngredients = hopIngredients; }
	
	public int compareTo(Hop h) {
		return name.compareTo(h.getName());
	}
}
