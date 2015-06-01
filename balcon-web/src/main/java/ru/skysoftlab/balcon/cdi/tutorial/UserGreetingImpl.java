package ru.skysoftlab.balcon.cdi.tutorial;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

@Alternative
public class UserGreetingImpl implements Greeting {

    private static final long serialVersionUID = 1L;
    
	@Inject
    private UserInfo user;

    @Override
    public String getText() {
        return "Hello, " + user.getName() + "!";
    }

}