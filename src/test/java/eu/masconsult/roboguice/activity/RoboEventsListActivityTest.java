package eu.masconsult.roboguice.activity;

import org.junit.Before;

import android.app.ListActivity;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;

public class RoboEventsListActivityTest extends ActivityEventsTest {

	public RoboEventsListActivityTest() {
		super(RoboEventsListActivity.class);
	}

	@Override
	@Before
	public void setUp() throws Exception {
		// We want to skip the real functionality of Activity (even though it's
		// shadowed and just test the firing of events)
		Robolectric.bindShadowClass(ShadowListActivity.class);
		super.setUp();
	}

	@Implements(ListActivity.class)
	public static class ShadowListActivity extends
			com.xtremelabs.robolectric.shadows.ShadowListActivity {

		@Override
		@Implementation
		public void setContentView(int layoutResId) {
		}

	}
}
