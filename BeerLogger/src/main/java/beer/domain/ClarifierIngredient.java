package beer.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.log4j.Logger;

@Entity
public class ClarifierIngredient {
	
	private static Logger logger = Logger.getLogger(ClarifierIngredient.class);
	
	private int id;
	@Id 
	@GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	private Clarifier clarifier = new Clarifier();
	@ManyToOne
	public Clarifier getClarifier() {return clarifier;}
	public void setClarifier(Clarifier clarifier) {this.clarifier = clarifier;}
	
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