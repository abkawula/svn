package beer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HopIngredient {
	
	private int id;
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	private Hop hop;
	@ManyToOne
	public Hop getHop() {return hop;}
	public void setHop(Hop hop) {this.hop = hop;}
	
	private double quantity;
	public double getQuantity() {return quantity;}
	public void setQuantity(double quantity) {this.quantity = quantity;}
	
	private String pelletLeaf;
	public String getPelletLeaf() {return pelletLeaf;}
	public void setPelletLeaf(String pelletLeaf) {this.pelletLeaf = pelletLeaf;}
	
	private String boilTime;
	public String getBoilTime() {return boilTime;}
	public void setBoilTime(String boilTime) {this.boilTime = boilTime;}
	
}
