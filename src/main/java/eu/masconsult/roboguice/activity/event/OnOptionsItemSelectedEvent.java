package eu.masconsult.roboguice.activity.event;

import android.view.MenuItem;

public class OnOptionsItemSelectedEvent {

	protected MenuItem item;
	protected boolean handled;

	public OnOptionsItemSelectedEvent(MenuItem item) {
		this.item = item;
	}

	public MenuItem getItem() {
		return item;
	}

	public void setHandled() {
		this.handled = true;
	}

	public boolean isHandled() {
		return handled;
	}
}
