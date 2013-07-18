package eu.masconsult.roboguice.activity.event;

import android.view.KeyEvent;

public class OnKeyMultipleEvent {

	protected int keyCode;
	protected int repeatCount;
	protected KeyEvent event;
	protected boolean handled;

	public OnKeyMultipleEvent(int keyCode, int repeatCount, KeyEvent event) {
		this.keyCode = keyCode;
		this.repeatCount = repeatCount;
		this.event = event;
	}

	public int getKeyCode() {
		return keyCode;
	}
	
	public int getRepeatCount() {
		return repeatCount;
	}

	public KeyEvent getEvent() {
		return event;
	}

	public void setHandled() {
		this.handled = true;
	}

	public boolean isHandled() {
		return handled;
	}
}
