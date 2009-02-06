package beer.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class MashSchedule {

	private int id;
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	private String category;
	public String getCategory() {return category;}
	public void setCategory(String category) {this.category = category;}
	
	private List<MashStep> mashSteps;
	@OneToMany(mappedBy="mashSchedule", cascade = CascadeType.ALL)	
	public List<MashStep> getMashSteps() {return mashSteps;}
	public void setMashSteps(List<MashStep> mashSteps) {this.mashSteps = mashSteps;}
	
	
}
