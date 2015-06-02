package ru.skysoftlab.balcon.persistence.order;

import java.io.Serializable;
import java.util.List;

import ru.skysoftlab.balcon.persistence.template.Template;

public class Order implements Serializable{

	private static final long serialVersionUID = -4203133288559339386L;
	
	private Template template;

	List<WorkAndMaterial> wmList;
	
	Integer discount;
	
	Integer prepayment;
	
	Integer residue;
	
	Contacts contacts;
}
