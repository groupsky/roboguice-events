package eu.masconsult.roboguice.activity.event;

import android.view.Menu;

public class OnOptionsMenuClosedEvent {

	protected Menu menu;

	public OnOptionsMenuClosedEvent(Menu menu) {
		this.menu = menu;
	}

	public Menu getMenu() {
		return menu;
	}

}
