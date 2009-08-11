package beer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FlavoringIngredient {

	private int id;
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	private Flavoring flavoring = new Flavoring();
	@ManyToOne
	public Flavoring getFlavoring() {return flavoring;}
	public void setFlavoring(Flavoring flavoring) {this.flavoring = flavoring;}
	
	private double quantity;
	public double getQuantity() {return quantity;}
	public void setQuantity(double quantity) {this.quantity = quantity;}
	
	private Recipe recipe;
	@ManyToOne
	public Recipe getRecipe() { return recipe; }
	public void setRecipe(Recipe recipe) { this.recipe = recipe; }
}
