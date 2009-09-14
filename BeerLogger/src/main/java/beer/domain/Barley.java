package beer.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;

@Entity
@Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_ONLY)
public class Barley implements Comparable<Barley> {

	private int id;
	@Id 
	@GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	private String variety;
	public String getVariety() {return variety;}
	public void setVariety(String variety) {this.variety = variety;}
	
	private String country;
	public String getCountry() { return country; }
	public void setCountry(String country) {this.country = country; }
	
	// pound per gallon
	private double gravity;
	public double getGravity() { return gravity; }
	public void setGravity(double gravity) { this.gravity = gravity; }
	
	// degrees Lovibond
	private double color;
	public double getColor() { return color; }
	public void setColor(double color) {this.color = color; }
	
	private String comment;
	public String getComment() { return comment; }
	public void setComment(String comment) { this.comment = comment; }
	
	private List<BarleyIngredient> barleyIngredients;
	@OneToMany(mappedBy="barley")
	public List<BarleyIngredient> getBarleyIngredients() { return barleyIngredients; }
	public void setBarleyIngredients(List<BarleyIngredient> barleyIngredients) { this.barleyIngredients = barleyIngredients; }
	
	public int compareTo(Barley b) {
		return this.variety.compareTo(b.getVariety());
	}
	
	
	
	

}
