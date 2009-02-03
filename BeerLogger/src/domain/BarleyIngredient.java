package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BarleyIngredient {
	
	@Id @GeneratedValue
	private int id;
	@ManyToOne
	private Barley barley;
	private double quantity;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Barley getBarley() {
		return barley;
	}
	public void setBarley(Barley barley) {
		this.barley = barley;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
