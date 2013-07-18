package eu.masconsult.roboguice.activity.event;

public class OnBackPressedEvent {

	protected boolean handled;

	public void cancelBack() {
		this.handled = true;
	}

	public boolean isBackCanceled() {
		return handled;
	}
}
