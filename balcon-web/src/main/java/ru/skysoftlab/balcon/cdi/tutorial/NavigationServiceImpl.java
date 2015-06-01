package ru.skysoftlab.balcon.cdi.tutorial;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.cdi.NormalUIScoped;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.UI;

@NormalUIScoped
public class NavigationServiceImpl implements NavigationService {
	
	private static final long serialVersionUID = 1L;

    @Inject
    private CDIViewProvider viewProvider;

    @Inject
    private ErrorView errorView;

    @Inject
    private UI ui;

    @PostConstruct
    public void initialize() {
        if (ui.getNavigator() == null) {
            Navigator navigator = new Navigator(ui, ui);
            navigator.addProvider(viewProvider);
            navigator.setErrorView(errorView);
        }
    }

    @Override
    public void onNavigationEvent(@Observes NavigationEvent event) {
        try {
            ui.getNavigator().navigateTo(event.getNavigateTo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
