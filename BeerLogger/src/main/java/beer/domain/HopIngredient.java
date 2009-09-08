package beer.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;

@Entity
public class HopIngredient {
	
	private static Logger logger = Logger.getLogger(HopIngredient.class);
	
	private int id;
	@Id 
	@GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	private Hop hop = new Hop();
	@ManyToOne
	public Hop getHop() {return hop;}
	public void setHop(Hop hop) {this.hop = hop;}
	
	private Recipe recipe = new Recipe();
	@ManyToOne(cascade = CascadeType.ALL)
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
		double utilization = 0;
		if (NumberUtils.isNumber(boilTime)) {
			utilization = (getBignessFactor() * getBoilTimeFactor() );
		} 
		logger.debug("utilization = " + utilization);
		return utilization;
	}
	
	@Transient
	private double getBignessFactor() {
		double bignessFactor = 1.65 * Math.pow(0.000125, recipe.getInitialGravity() - 1); 
		logger.debug("bignessFactor = " + bignessFactor);
		return bignessFactor;
	}
	
	@Transient
	private double getBoilTimeFactor() {
		double boidTimeFactor = ((1 - Math.pow(Math.E, -.04 * Double.parseDouble(boilTime))) / 4.15); 
		logger.debug("boilTimeFactor = " + boidTimeFactor);
		return boidTimeFactor;
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
		double ibu = getUtilization() * getMillisPerGallonAlpha();
		logger.debug("ibu = " + ibu);
		return ibu;
	}
	
	@Transient
	private double getMillisPerGallonAlpha() {
		double millisPerGallonAlpha = ((hop.getAlpha() * quantity * 74.90) / recipe.getBatchSize());
		logger.debug("millisPerGallonAlpha = " + millisPerGallonAlpha);
		return millisPerGallonAlpha;
	}
}
