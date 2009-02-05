package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Recipe {
	
	public static enum Style {
		AMBER_ALE("Amber Ale"),
		AMBER_LAGER("Amber Lager"),
		BARLEY_WINE("Barley Wine"),
		BELGIAN("Belgian"),
		BITTER("Bitter"),
		BOCK("Bock"),
		BRITISH_ALE("British Ale"),
		BROWN_ALE("Brown Ale"),
		DARK_ALE("Dark Ale"),
		DARK_LAGER("Dark Lager"),
		GOLDEN_ALE("GolDen Ale"),
		IPA("IPA"),
		LIGHT_LAGER("Light Lager"),
		PALE_ALE("Pale Ale"),
		PORTER("Porter"),
		RED_ALE("Red Ale"),
		RYE_ALE("Rye Ale"),
		SCOTTISH_ALE("Scottish Ale"),
		SEASONAL("Seasonal Beer"),
		STOUT("Stout"),
		WHEAT("Wheat Ale");
		
		private String name;
		private Style(String name) {this.name = name;}
		public String getName() {return name;}
	}
	
	private int id;
	@Id @GeneratedValue
	public int getId() { return id;	}
	public void setId(int id) {	this.id = id;}
	
	private String name;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	private List<HopIngredient> hops;
	@OneToMany(cascade = CascadeType.ALL)
	public List<HopIngredient> getHops() { return hops; }
	public void setHops(List<HopIngredient> hops) {	
		this.hops = hops;
	}
	
	private List<BarleyIngredient> barlies;
	@OneToMany(cascade = CascadeType.ALL)
	public List<BarleyIngredient> getBarlies() { 
		return barlies;
		}
	public void setBarlies(List<BarleyIngredient> barlies) {this.barlies = barlies;	}
	
	private List<YeastIngredient> yeasts;
	@OneToMany(cascade = CascadeType.ALL)
	public List<YeastIngredient> getYeasts() { return yeasts; }
	public void setYeasts(List<YeastIngredient> yeasts) { this.yeasts = yeasts;	}
	
	private List<AdditiveIngredient> additives;
	@OneToMany(cascade = CascadeType.ALL)
	public List<AdditiveIngredient> getAdditives() { return additives;}
	public void setAdditives(List<AdditiveIngredient> additives) {this.additives = additives;}
	
	private List<FlavoringIngredient> flavorings;
	@OneToMany(cascade = CascadeType.ALL)
	public List<FlavoringIngredient> getFlavorings() { return flavorings;}
	public void setFlavorings(List<FlavoringIngredient> flavorings) {this.flavorings = flavorings;}
	
	private double initialGravity;
	public double getInitialGravity() {return initialGravity;}
	public void setInitialGravity(double initialGravity) {this.initialGravity = initialGravity;}
	
	private double finalGravity;
	public double getFinalGravity() {return finalGravity;}
	public void setFinalGravity(double finalGravity) {this.finalGravity = finalGravity;}
	
	private Style style;
	public Style getStyle() { return style; }
	public void setStyle(String style) { this.style = Style.valueOf(style); }
	public void setStyle(Style style) { this.style = style; }
	
}