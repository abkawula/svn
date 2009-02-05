package beer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hop {
	
	private int id;
	@Id @GeneratedValue
	public int getId() { return id; }
	public void setId(int id) {this.id = id;}
	
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	private String country;
	public String getCountry() {return country;}
	public void setCountry(String country) {this.country = country;}
	
	private String application;
	public String getApplication() {return application;}
	public void setApplication(String application) {this.application = application;}
	
	private String aroma_bitter;
	public String getAroma_bitter() {return aroma_bitter;}
	public void setAroma_bitter(String aroma_bitter) {this.aroma_bitter = aroma_bitter;}
	
	private double alpha;
	public double getAlpha() {return alpha;}
	public void setAlpha(double alpha) {this.alpha = alpha;}
	
	private String storage;
	public String getStorage() {return storage;}
	public void setStorage(String storage) {this.storage = storage;}
	
	private String description;
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
	private Integer category;
	public Integer getCategory() {return category;}
	public void setCategory(Integer category) {this.category = category;}
	
}
