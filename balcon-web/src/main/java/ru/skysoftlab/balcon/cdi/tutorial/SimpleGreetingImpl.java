package ru.skysoftlab.balcon.cdi.tutorial;

import javax.enterprise.inject.Default;

@Default
public class SimpleGreetingImpl implements Greeting {
	
	private static final long serialVersionUID = 1L;

    @Override
    public String getText() {
        return "Hello, World!";
    }
}