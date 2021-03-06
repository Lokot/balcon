package ru.skysoftlab.balcon.ui;

import javax.inject.Inject;

import ru.skysoftlab.balcon.cdi.tutorial.NavigationEvent;

import com.vaadin.navigator.View;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.VerticalLayout;

/**
 * Базовый класс для страниц.
 * 
 * @author Артём
 *
 */
public abstract class BaseMenuView extends CustomComponent implements View {

	private static final long serialVersionUID = 6006817026658320555L;

	@Inject
	private javax.enterprise.event.Event<NavigationEvent> navigationEvent;

	protected final VerticalLayout layout = new VerticalLayout();

	protected MenuBar barmenu = new MenuBar();

	public BaseMenuView() {
		super();
		setCompositionRoot(layout);
		layout.setMargin(true);
		layout.addComponent(barmenu);
		createMenu();
	}

	/**
	 * Создает меню.
	 */
	private void createMenu() {
		for (MenuItems myMenu : MenuItems.values()) {
			MenuItem item = barmenu.addItem(myMenu.getName(), null, null);
			for (ru.skysoftlab.balcon.ui.MenuItems.MenuItem myItem : myMenu
					.getItems()) {
				item.addItem(myItem.getName(),
						new NavigationCommand(myItem.getUrl()));
			}
		}
	}

	/**
	 * Комнда для навигации.
	 * 
	 * @author Артём
	 *
	 */
	public class NavigationCommand implements MenuBar.Command {

		private static final long serialVersionUID = -2959468243274000189L;

		/** Наименование страницы. */
		private String view;

		public NavigationCommand(String view) {
			this.view = view;
		}

		@Override
		public void menuSelected(MenuItem selectedItem) {
			navigationEvent.fire(new NavigationEvent(view));
		}

	}

}
