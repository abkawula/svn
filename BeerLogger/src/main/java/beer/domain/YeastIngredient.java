package beer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class YeastIngredient {

	private int id;
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	private Yeast yeast = new Yeast();
	@ManyToOne
	public Yeast getYeast() {return yeast;}
	public void setYeast(Yeast yeast) {this.yeast = yeast;}
	
	private double quantity;
	public double getQuantity() {return quantity;}
	public void setQuantity(double quantity) {this.quantity = quantity;}
	
	private Recipe recipe;
	@ManyToOne
	public Recipe getRecipe() { return recipe; }
	public void setRecipe(Recipe recipe) { this.recipe = recipe; }
}
