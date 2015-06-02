package ru.skysoftlab.balcon.persistence.template;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Template implements Serializable{

	private static final long serialVersionUID = -8239261045111274336L;
	
	private Integer id;
	
	private List<Block> blocks = new ArrayList<>();

}
