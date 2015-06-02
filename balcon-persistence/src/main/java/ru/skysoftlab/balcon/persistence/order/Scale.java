package ru.skysoftlab.balcon.persistence.order;

/**
 * Единицы измерения.
 * 
 * @author Артём
 *
 */
public enum Scale {

	M2("м. кв."), M3("м. куб."), MP("м. п."), SHT("шт."), ED("ед."), NONE;

	private String name;

	private Scale() {
		this.setName("");
	}

	private Scale(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

}
