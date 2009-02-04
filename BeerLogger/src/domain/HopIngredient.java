package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HopIngredient {

	@Id @GeneratedValue
	private int id;
	@ManyToOne
	private Hop hop;
	private double quantity;
	private String pelletLeaf;
	private int boilTime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Hop getHop() {
		return hop;
	}
	public void setHop(Hop hop) {
		this.hop = hop;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getPelletLeaf() {
		return pelletLeaf;
	}
	public void setPelletLeaf(String pelletLeaf) {
		this.pelletLeaf = pelletLeaf;
	}
	public int getBoilTime() {
		return boilTime;
	}
	public void setBoilTime(int boilTime) {
		this.boilTime = boilTime;
	}
	
}
