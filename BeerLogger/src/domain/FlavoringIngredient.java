package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FlavoringIngredient {

	@Id @GeneratedValue
	private int id;
	@ManyToOne
	private Flavoring flavoring;
	private double quantity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Flavoring getFlavoring() {
		return flavoring;
	}
	public void setFlavoring(Flavoring flavoring) {
		this.flavoring = flavoring;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
}
