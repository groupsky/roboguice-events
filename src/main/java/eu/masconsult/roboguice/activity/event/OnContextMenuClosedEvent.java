package eu.masconsult.roboguice.activity.event;

import android.view.Menu;

public class OnContextMenuClosedEvent {

	protected Menu menu;

	public OnContextMenuClosedEvent(Menu menu) {
		this.menu = menu;
	}

	public Menu getMenu() {
		return menu;
	}

}
