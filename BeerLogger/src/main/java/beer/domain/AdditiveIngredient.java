package beer.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class AdditiveIngredient {

	private int id;
	@Id 
	@GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	private Additive additive = new Additive();
	@ManyToOne
	public Additive getAdditive() {return additive;}
	public void setAdditive(Additive additive) {this.additive = additive;}
	@Transient
	public int getAdditiveId() {
		return additive.getId();
	}
	public void setAdditiveId(int additiveId) {
		additive = new Additive();
		additive.setId(additiveId);
	}
	
	private double quantity;
	public double getQuantity() {return quantity;}
	public void setQuantity(double quantity) {this.quantity = quantity;	}
	
	private Recipe recipe = new Recipe();
	@ManyToOne(cascade = CascadeType.ALL)
	public Recipe getRecipe() { return recipe; }
	public void setRecipe(Recipe recipe) { this.recipe = recipe; }
}
