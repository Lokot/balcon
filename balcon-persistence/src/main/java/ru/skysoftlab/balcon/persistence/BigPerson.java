package ru.skysoftlab.balcon.persistence;

import javax.persistence.Entity;

@Entity(name = "bigPerson")
//@Table(name = "big_person", schema = "public")
public class BigPerson extends Person {
	
	private static final long serialVersionUID = 7241121612521617056L;
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
