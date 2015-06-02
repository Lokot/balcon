package ru.skysoftlab.balcon.persistence.order;

import java.io.Serializable;

/**
 * Вид работы или материала.
 * 
 * @author Артём
 *
 */
public class WMType implements Serializable {

	private static final long serialVersionUID = -4203133288559339386L;
	
	private Integer id;
	
	private String name;
	
	private Type type;
	
	private Scale scale;
	
	private Integer price;
	
	// TODO если материал, то ссылка на сайт
	
	

}
