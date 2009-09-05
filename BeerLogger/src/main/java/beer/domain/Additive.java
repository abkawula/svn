package beer.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Additive implements Comparable<Additive> {

	private int id;
	@Id 
	@GeneratedValue
	public int getId() {return id;}
	public void setId(int id) { this.id = id;}

	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;	}
	
	private double gravity;
	public double getGravity() { return gravity; }
	public void setGravity(double gravity) { this.gravity = gravity; }
	
	private double color;
	public double getColor() { return color; }
	public void setColor(double color) { this.color = color; }
	
	private String comment;
	public String getComment() { return comment; }
	public void setComment(String comment) {this.comment = comment; }
	
	private List<AdditiveIngredient> additiveIngredients;
	@OneToMany(mappedBy="additive")
	public List<AdditiveIngredient> getAdditiveIngredients() { return additiveIngredients; }
	public void setAdditiveIngredients(List<AdditiveIngredient> additiveIngredients) { this.additiveIngredients = additiveIngredients; }
	
	public int compareTo(Additive a) {
		return name.compareTo(a.getName());
	}
}
