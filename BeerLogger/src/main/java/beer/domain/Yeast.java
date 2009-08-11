package beer.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Yeast implements Comparable<Yeast> {

	private int id;
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	private int category;
	public int getCategory() {return category;}
	public void setCategory(int yeastCategory) {this.category = yeastCategory;}
	
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	private String brand;
	public String getBrand() {return brand;}
	public void setBrand(String brand) {this.brand = brand;}
	
	private List<YeastIngredient> yeastIngredients;
	@OneToMany(mappedBy="yeast")
	public List<YeastIngredient> getYeastIngredients() { return yeastIngredients; }
	public void setYeastIngredients(List<YeastIngredient> yeastIngredients) { this.yeastIngredients = yeastIngredients; }
	
	public int compareTo(Yeast y) {
		return name.compareTo(y.getName());
	}
}
