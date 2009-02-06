package beer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MashStep {
	
	private int id;
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
//	private MashSchedule mashSchedule;
//	@ManyToOne
//	public MashSchedule getMashSchedule() {return mashSchedule;}
//	public void setMashSchedule(MashSchedule mashSchedule) {this.mashSchedule = mashSchedule;}
	
	private int order;
	public int getOrder() {return order;}
	public void setOrder(int order) {this.order = order;}
	
	private double waterQuantity;
	public double getWaterQuantity() {return waterQuantity;}
	public void setWaterQuantity(double waterQuantity) {this.waterQuantity = waterQuantity;}
	
	private int temp;
	public int getTemp() {return temp;}
	public void setTemp(int temp) {this.temp = temp;}
	
	
}
