package eu.masconsult.roboguice.activity;

import org.junit.Before;

import com.google.android.maps.MapActivity;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;

public class RoboEventsMapActivityTest extends ActivityEventsTest {

	public RoboEventsMapActivityTest() {
		super(MyMapActivity.class);
	}

	@Override
	@Before
	public void setUp() throws Exception {
		// We want to skip the real functionality of Activity (even though it's
		// shadowed and just test the firing of events)
		Robolectric.bindShadowClass(ShadowMapActivity.class);
		super.setUp();
	}

	@Implements(MapActivity.class)
	public static class ShadowMapActivity extends
			com.xtremelabs.robolectric.shadows.ShadowMapActivity {

		@Override
		@Implementation
		public void setContentView(int layoutResId) {
		}
	}

	public static class MyMapActivity extends RoboEventsMapActivity {

		@Override
		protected boolean isRouteDisplayed() {
			return false;
		}

	}
}
