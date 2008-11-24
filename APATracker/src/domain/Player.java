package domain;

import java.io.Serializable;

public class Player implements Serializable {

	private int id;
	private String firstName;
	private String lastName;
	private long apaId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getApaId() {
		return apaId;
	}
	public void setApaId(long apaId) {
		this.apaId = apaId;
	}
}
