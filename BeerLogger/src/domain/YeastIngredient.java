package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class YeastIngredient {

	@Id @GeneratedValue
	private int id;
	@ManyToOne
	private Yeast yeast;
	private double quantity;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Yeast getYeast() {
		return yeast;
	}
	public void setYeast(Yeast yeast) {
		this.yeast = yeast;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
}
