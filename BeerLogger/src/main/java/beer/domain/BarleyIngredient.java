package beer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	private double quantity;
	public double getQuantity() {return quantity;}
	public void setQuantity(double quantity) {this.quantity = quantity;}

}
