package beer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AdditiveIngredient {

	private int id;
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	private Additive additive = new Additive();
	@ManyToOne
	public Additive getAdditive() {return additive;}
	public void setAdditive(Additive additive) {this.additive = additive;}
	
	private double quantity;
	public double getQuantity() {return quantity;}
	public void setQuantity(double quantity) {this.quantity = quantity;	}
	
	private Recipe recipe;
	@ManyToOne
	public Recipe getRecipe() { return recipe; }
	public void setRecipe(Recipe recipe) { this.recipe = recipe; }
}
