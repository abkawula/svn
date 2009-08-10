package beer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class HopIngredient {
	
	private int id;
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	private Hop hop = new Hop();
	@ManyToOne
	public Hop getHop() {return hop;}
	public void setHop(Hop hop) {this.hop = hop;}
	
	private Recipe recipe;
	@ManyToOne
	public Recipe getRecipe() { return recipe; }
	public void setRecipe(Recipe recipe) { this.recipe = recipe; }
	
	private double quantity;
	public double getQuantity() {return quantity;}
	public void setQuantity(double quantity) {this.quantity = quantity;}
	
	private String pelletLeaf;
	public String getPelletLeaf() {return pelletLeaf;}
	public void setPelletLeaf(String pelletLeaf) {this.pelletLeaf = pelletLeaf;}
	
	private String boilTime;
	public String getBoilTime() {return boilTime;}
	public void setBoilTime(String boilTime) {this.boilTime = boilTime;}
	
	@Transient
	public String getUtilization() {
		return recipe.toString();
	}
	
	@Transient
	public String getIBU() {
		return recipe.toString();
	}
	
}
