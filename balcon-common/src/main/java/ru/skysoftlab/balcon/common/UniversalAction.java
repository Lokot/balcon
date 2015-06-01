package ru.skysoftlab.balcon.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UniversalAction {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response);
	
	public void doPost(HttpServletRequest request, HttpServletResponse response);

}
