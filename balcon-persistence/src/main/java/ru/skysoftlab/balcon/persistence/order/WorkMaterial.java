package ru.skysoftlab.balcon.persistence.order;

import java.io.Serializable;

public class WorkMaterial implements Serializable {

	private static final long serialVersionUID = -4203133288559339386L;
	
	private Integer id;
	
	private WMType type;
	
	private Integer count;
	
}
