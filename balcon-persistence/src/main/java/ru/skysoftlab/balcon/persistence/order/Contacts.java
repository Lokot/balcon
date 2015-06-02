package ru.skysoftlab.balcon.persistence.order;

import java.io.Serializable;
import java.util.Date;

public class Contacts implements Serializable{
	
	private static final long serialVersionUID = -4203133288559339386L;
	
	String istObr;
	
	String manager;
	
	String sostavil;
	
	Date date;
	
	Date dateDemont;
	
	Date dateDost;
	
	Date dateInstallation;
	
	String adress;
	
	Boolean lift;
	
}
