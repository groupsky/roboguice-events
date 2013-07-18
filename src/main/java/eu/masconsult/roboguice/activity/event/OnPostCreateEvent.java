package eu.masconsult.roboguice.activity.event;

import android.os.Bundle;

public class OnPostCreateEvent {

    protected Bundle savedInstanceState;

    public OnPostCreateEvent(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
    }

    public Bundle getSavedInstanceState() {
        return savedInstanceState;
    }
}
