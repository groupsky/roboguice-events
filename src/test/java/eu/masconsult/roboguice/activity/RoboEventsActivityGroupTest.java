package eu.masconsult.roboguice.activity;

import org.junit.Before;

import android.app.ActivityGroup;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;

@SuppressWarnings("deprecation")
public class RoboEventsActivityGroupTest extends ActivityEventsTest {

	public RoboEventsActivityGroupTest() {
		super(RoboEventsActivityGroup.class);
	}

	@Override
	@Before
	public void setUp() throws Exception {
		// We want to skip the real functionality of Activity (even though it's
		// shadowed and just test the firing of events)
		Robolectric.bindShadowClass(ShadowActivityGroup.class);
		super.setUp();
	}

	@Implements(ActivityGroup.class)
	public static class ShadowActivityGroup extends
			com.xtremelabs.robolectric.shadows.ShadowActivityGroup {

		@Override
		@Implementation
		public void setContentView(int layoutResId) {
		}

	}
}
