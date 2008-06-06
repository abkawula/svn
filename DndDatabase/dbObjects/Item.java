package dbObjects;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Item {
	
	public enum Type{
		CLOTHING,
		ARMOR,
		WEAPON,
		SCROLL,
		MISC
	}

	@Id
	private long itemID;
	private Type type;
	private String name;
	
	@ManyToMany
	private List<Character> characters = new ArrayList<Character>();

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
