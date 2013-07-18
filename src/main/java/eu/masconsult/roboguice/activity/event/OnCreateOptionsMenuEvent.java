package eu.masconsult.roboguice.activity.event;

import android.view.Menu;

public class OnCreateOptionsMenuEvent {

	protected Menu menu;
	protected boolean menuEnabled;

	public OnCreateOptionsMenuEvent(Menu menu) {
		this.menu = menu;
	}

	public Menu getMenu() {
		return menu;
	}

	public void menuEnabled() {
		this.menuEnabled = true;
	}

	public boolean isMenuEnabled() {
		return menuEnabled;
	}
}
