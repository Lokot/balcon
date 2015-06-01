package ru.skysoftlab.balcon.cdi.tutorial;

import javax.inject.Inject;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Theme("valo")
@CDIUI("")
@Push
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    @Inject
    private javax.enterprise.event.Event<NavigationEvent> navigationEvent;

    @Override
    protected void init(VaadinRequest request) {
    	// TODO включить авторизацию
        //navigationEvent.fire(new NavigationEvent("login"));
        navigationEvent.fire(new NavigationEvent("orders"));
    	
    }

}
