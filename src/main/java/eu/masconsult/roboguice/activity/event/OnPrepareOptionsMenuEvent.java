package eu.masconsult.roboguice.activity.event;

import android.view.Menu;

public class OnPrepareOptionsMenuEvent {

	protected Menu menu;
	protected boolean hasMenu;

	public OnPrepareOptionsMenuEvent(Menu menu) {
		this.menu = menu;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setHasMenu() {
		this.hasMenu = true;
	}

	public boolean hasMenu() {
		return hasMenu;
	}
}
