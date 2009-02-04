package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Yeast {

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
}
