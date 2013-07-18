package eu.masconsult.roboguice.activity.event;

import android.os.Bundle;

public class OnRestoreInstanceStateEvent {

    protected Bundle savedInstanceState;

    public OnRestoreInstanceStateEvent(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
    }

    public Bundle getSavedInstanceState() {
        return savedInstanceState;
    }
}
