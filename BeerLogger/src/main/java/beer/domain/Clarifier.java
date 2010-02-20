package beer.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;

@Entity
//@Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_ONLY)
public class Clarifier {
	
	private int id;
	@Id
	@GeneratedValue
	public int getId() { return id;}
	public void setId(int id) { this.id = id; }
	
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	private String description;
	@Lob
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
	private List<ClarifierIngredient> clarifierIngredients;
	@OneToMany(mappedBy="clarifier")
	public List<ClarifierIngredient> getClarifierIngredients() { return clarifierIngredients; }
	public void setClarifierIngredients(List<ClarifierIngredient> clarifierIngredients) { this.clarifierIngredients = clarifierIngredients; }

}
