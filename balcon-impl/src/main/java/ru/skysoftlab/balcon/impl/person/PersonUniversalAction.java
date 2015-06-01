package ru.skysoftlab.balcon.impl.person;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.skysoftlab.balcon.common.UniversalAction;
import ru.skysoftlab.balcon.common.annotation.SimpleQualifier;

@SimpleQualifier(value = "person")
public class PersonUniversalAction implements UniversalAction {

	@Inject
	private PersonAction pa;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		pa.createPerson();

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
