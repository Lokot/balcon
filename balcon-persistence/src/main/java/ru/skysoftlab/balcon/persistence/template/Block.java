package ru.skysoftlab.balcon.persistence.template;

import java.io.Serializable;
import java.util.List;

import ru.skysoftlab.balcon.persistence.order.WMType;

public class Block implements Serializable {

	private static final long serialVersionUID = -8239261045111274336L;

	private Integer id;

	List<WMType> worksAndMaterials;

}
