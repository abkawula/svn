package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hop {

	@Id @GeneratedValue
	private int id;
	private String name;
	private String coutry;
	private String application;
	private String aroma_bitter;
	private double alpha;
	private String storage;
	private String description;
	private int category;
	
	
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
	public String getCoutry() {
		return coutry;
	}
	public void setCoutry(String coutry) {
		this.coutry = coutry;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	public String getAroma_bitter() {
		return aroma_bitter;
	}
	public void setAroma_bitter(String aroma_bitter) {
		this.aroma_bitter = aroma_bitter;
	}
	public double getAlpha() {
		return alpha;
	}
	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
}
