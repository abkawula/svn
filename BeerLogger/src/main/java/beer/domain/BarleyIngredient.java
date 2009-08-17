package beer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class BarleyIngredient {
	
	private int id;
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	private Barley barley = new Barley();
	@ManyToOne
	public Barley getBarley() {return barley;}
	public void setBarley(Barley barley) {this.barley = barley;}
	@Transient
	public int getBarleyId() {
		return barley.getId();
	}
	public void setBarleyId(int barleyId) {
		barley = new Barley();
		barley.setId(barleyId);
	}
	
	private double quantity;
	public double getQuantity() {return quantity;}
	public void setQuantity(double quantity) {this.quantity = quantity;}
	
	private Recipe recipe;
	@ManyToOne
	public Recipe getRecipe() { return recipe; }
	public void setRecipe(Recipe recipe) { this.recipe = recipe; }

}
