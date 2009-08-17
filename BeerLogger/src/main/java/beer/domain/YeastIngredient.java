package beer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

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
	@Transient
	public int getYeastId() {
		return yeast.getId();
	}
	public void setYeast(int yeastId) {
		yeast = new Yeast();
		yeast.setId(yeastId);
	}
	
	private double quantity;
	public double getQuantity() {return quantity;}
	public void setQuantity(double quantity) {this.quantity = quantity;}
	
	private Recipe recipe;
	@ManyToOne
	public Recipe getRecipe() { return recipe; }
	public void setRecipe(Recipe recipe) { this.recipe = recipe; }
}
