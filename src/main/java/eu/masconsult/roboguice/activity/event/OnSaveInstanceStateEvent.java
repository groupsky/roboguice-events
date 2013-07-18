package eu.masconsult.roboguice.activity.event;

import android.os.Bundle;

public class OnSaveInstanceStateEvent {

    protected Bundle outState;

    public OnSaveInstanceStateEvent(Bundle outState) {
        this.outState = outState;
    }

    public Bundle getOutState() {
        return outState;
    }
}
