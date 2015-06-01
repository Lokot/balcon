package ru.skysoftlab.balcon.ui;

/**
 * Список меню.
 * 
 * @author Артём
 *
 */
public enum MenuItems {

	/** Заказ-наряд */
	Orders("Заказ-наряд", null, new MenuItem[] {
			new MenuItem("Список", "orders"),
			new MenuItem("Создать", "editOrder") }),
	/** Шаблоны ЗН */
	Templates("Шаблоны ЗН", null, new MenuItem[] {
			new MenuItem("Список", "templates"),
			new MenuItem("Создать", "editTemplate") }),
	/** Блоки ЗН */
	TemplateBlocks("Блоки ЗН", null, new MenuItem[] {
			new MenuItem("Список", "hello"), new MenuItem("Создать", "hello") }),
	/** Виды работ */
	Works("Виды работ", null, new MenuItem[] { new MenuItem("Список", "hello"),
			new MenuItem("Создать", "hello") });

	private String name;

	private String url;

	private MenuItem[] items;

	private MenuItems(String name, String url, MenuItem[] items) {
		this.name = name;
		this.url = url;
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public MenuItem[] getItems() {
		return items;
	}

	public static class MenuItem {

		private String name;

		private String url;

		private MenuItem(String name, String url) {
			this.name = name;
			this.url = url;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}

}
