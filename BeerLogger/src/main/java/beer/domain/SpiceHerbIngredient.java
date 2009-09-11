package beer.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.log4j.Logger;

@Entity
public class SpiceHerbIngredient {
	
	private static Logger logger = Logger.getLogger(SpiceHerbIngredient.class);
	
	private int id;
	@Id 
	@GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	private SpiceHerb spiceHerb = new SpiceHerb();
	@ManyToOne
	public SpiceHerb getSpiceHerb() {return spiceHerb;}
	public void setSpiceHerb(SpiceHerb spiceHerb) {this.spiceHerb = spiceHerb;}
	
	private Recipe recipe = new Recipe();
	@ManyToOne(cascade = CascadeType.ALL)
	public Recipe getRecipe() { return recipe; }
	public void setRecipe(Recipe recipe) { this.recipe = recipe; }
	
	private double quantity;
	public double getQuantity() {return quantity;}
	public void setQuantity(double quantity) {this.quantity = quantity;}
	
	private String boilTime;
	public String getBoilTime() {return boilTime;}
	public void setBoilTime(String boilTime) {this.boilTime = boilTime;}
}