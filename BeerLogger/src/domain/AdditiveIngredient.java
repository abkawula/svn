package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AdditiveIngredient {

	@Id @GeneratedValue
	private int id;
	@ManyToOne
	private Additive additive;
	private double quantity;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Additive getAdditive() {
		return additive;
	}
	public void setAdditive(Additive additive) {
		this.additive = additive;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
}
