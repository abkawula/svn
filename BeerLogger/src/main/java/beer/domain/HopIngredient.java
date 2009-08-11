package beer.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.apache.commons.lang.math.NumberUtils;

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
	public double getUtilization(){
		if (NumberUtils.isNumber(boilTime)) {
			return (getBignessFactor() * getBoilTimeFactor() );
		} 
		
		return 0;
	}
	
	@Transient
	private double getBignessFactor() {
		return 1.65 * Math.pow(0.000125, recipe.getInitialGravity() - 1);
	}
	
	@Transient
	private double getBoilTimeFactor() {
		return ((1 - Math.pow(Math.E, -.04 * Double.parseDouble(boilTime))) / 4.15);
	}
	
//	To calculate IBUs, the formula is simple:
//
//		IBUs = decimal alpha acid utilization * mg/l of added alpha acids
//
//		To calculate the concentration of alpha acids you add to the wort:
//
//	mg/l of added alpha acids = decimal AA rating * ozs hops * 7490
//    -------------------------------------
//     volume of finished beer in gallons 

	@Transient
	public double getIBU() {
		return (getUtilization() * getMillisPerGallonAlpha());
	}
	
	@Transient
	private double getMillisPerGallonAlpha() {
		return ((hop.getAlpha() * quantity * 7490) / recipe.getBatchSize());
	}
}
