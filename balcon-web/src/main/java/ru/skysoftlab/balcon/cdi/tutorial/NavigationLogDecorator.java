package ru.skysoftlab.balcon.cdi.tutorial;

import java.util.logging.Logger;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class NavigationLogDecorator implements NavigationService {
	
	private static final long serialVersionUID = 1L;

    @Inject
    @Delegate
    @Any
    NavigationService delegate;

    @Inject
    private UserInfo userInfo;

    @Override
    public void onNavigationEvent(NavigationEvent event) {
        getLogger().info(
                userInfo.getName() + " navigated to " + event.getNavigateTo());
        delegate.onNavigationEvent(event);
    }

    private Logger getLogger() {
        return Logger.getLogger(this.getClass().getSimpleName());
    }

}
