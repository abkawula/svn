package beer.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

import beer.domain.AdditiveIngredient;
import beer.domain.BarleyIngredient;
import beer.domain.FlavoringIngredient;
import beer.domain.HopIngredient;
import beer.domain.Recipe;
import beer.domain.YeastIngredient;
import beer.domain.Recipe.Style;

public class RecipeForm {

	private int id;
	private String name;
	
	private List<HopIngredient> hops = LazyList.decorate(
			new ArrayList<HopIngredient>(), FactoryUtils.instantiateFactory(HopIngredient.class));
	
	private List<BarleyIngredient> barlies = LazyList.decorate(
			new ArrayList<BarleyIngredient>(), FactoryUtils.instantiateFactory(BarleyIngredient.class));
	
	private List<YeastIngredient> yeasts = LazyList.decorate(
			new ArrayList<YeastIngredient>(), FactoryUtils.instantiateFactory(YeastIngredient.class));
	
	private List<AdditiveIngredient> additives = LazyList.decorate(
			new ArrayList<AdditiveIngredient>(), FactoryUtils.instantiateFactory(AdditiveIngredient.class));
	
	private List<FlavoringIngredient> flavorings = LazyList.decorate(
			new ArrayList<FlavoringIngredient>(), FactoryUtils.instantiateFactory(FlavoringIngredient.class));
	
	private double initialGravity;
	private double finalGravity;
	private Style style;
	private int batchSize = 5;
	
	public RecipeForm(){}
	public RecipeForm(Recipe recipe) {
		id = recipe.getId();
		name = recipe.getName();
		hops = recipe.getHops();
		barlies = recipe.getBarlies();
		yeasts = recipe.getYeasts();
		additives = recipe.getAdditives();
		flavorings = recipe.getFlavorings();
		initialGravity = recipe.getInitialGravity();
		finalGravity = recipe.getFinalGravity();
		style = recipe.getStyle();
		batchSize = recipe.getBatchSize();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<HopIngredient> getHops() {
		return hops;
	}
	public void setHops(List<HopIngredient> hops) {
		this.hops = hops;
	}
	public List<BarleyIngredient> getBarlies() {
		return barlies;
	}
	public void setBarlies(List<BarleyIngredient> barlies) {
		this.barlies = barlies;
	}
	public List<YeastIngredient> getYeasts() {
		return yeasts;
	}
	public void setYeasts(List<YeastIngredient> yeasts) {
		this.yeasts = yeasts;
	}
	public List<AdditiveIngredient> getAdditives() {
		return additives;
	}
	public void setAdditives(List<AdditiveIngredient> additives) {
		this.additives = additives;
	}
	public List<FlavoringIngredient> getFlavorings() {
		return flavorings;
	}
	public void setFlavorings(List<FlavoringIngredient> flavorings) {
		this.flavorings = flavorings;
	}
	public double getInitialGravity() {
		return initialGravity;
	}
	public void setInitialGravity(double initialGravity) {
		this.initialGravity = initialGravity;
	}
	public double getFinalGravity() {
		return finalGravity;
	}
	public void setFinalGravity(double finalGravity) {
		this.finalGravity = finalGravity;
	}
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	public int getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	
	
}
