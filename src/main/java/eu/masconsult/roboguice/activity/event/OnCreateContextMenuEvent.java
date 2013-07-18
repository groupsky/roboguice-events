package eu.masconsult.roboguice.activity.event;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;

public class OnCreateContextMenuEvent {

	protected ContextMenu menu;
	protected View view;
	protected ContextMenuInfo menuInfo;

	public OnCreateContextMenuEvent(ContextMenu menu, View view,
			ContextMenuInfo menuInfo) {
		this.menu = menu;
		this.view = view;
		this.menuInfo = menuInfo;
	}

	public ContextMenu getMenu() {
		return menu;
	}
	
	public View getView() {
		return view;
	}
	
	public ContextMenuInfo getMenuInfo() {
		return menuInfo;
	}
}
