package beer.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Flavoring implements Comparable<Flavoring> {
	
	private int id;
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	private List<FlavoringIngredient> flavoringIngredients;
	@OneToMany(mappedBy="flavoring")
	public List<FlavoringIngredient> getFlavoringIngredients() { return flavoringIngredients; }
	public void setFlavoringIngredients(List<FlavoringIngredient> hopIngredients) { this.flavoringIngredients = hopIngredients; }
	
	public int compareTo(Flavoring f) {
		return name.compareTo(f.getName());
	}
	
}
