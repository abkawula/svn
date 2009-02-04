package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Barley {

	private int id;
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	private String variety;
	public String getVariety() {return variety;}
	public void setVariety(String variety) {this.variety = variety;}

}
