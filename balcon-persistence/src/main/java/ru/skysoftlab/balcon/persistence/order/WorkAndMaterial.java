package ru.skysoftlab.balcon.persistence.order;

import java.io.Serializable;
import java.util.List;

/**
 * Работа и материал для заказа.
 * 
 * @author Артём
 *
 */
public class WorkAndMaterial implements Serializable {

	private static final long serialVersionUID = -4203133288559339386L;
	
	private Integer id;
	
	private WorkMaterial work;
	
	private List<WorkMaterial> matrials;

}
