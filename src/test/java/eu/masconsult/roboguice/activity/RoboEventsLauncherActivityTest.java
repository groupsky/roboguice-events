package eu.masconsult.roboguice.activity;

import org.junit.Before;

import com.xtremelabs.robolectric.Robolectric;

import eu.masconsult.roboguice.activity.RoboEventsListActivityTest.ShadowListActivity;

public class RoboEventsLauncherActivityTest extends ActivityEventsTest {

	public RoboEventsLauncherActivityTest() {
		super(RoboEventsLauncherActivity.class);
	}

	@Override
	@Before
	public void setUp() throws Exception {
		// We want to skip the real functionality of Activity (even though it's
		// shadowed and just test the firing of events)
		Robolectric.bindShadowClass(ShadowListActivity.class);
		super.setUp();
	}

}
