package eu.masconsult.roboguice.activity;

import org.junit.Before;

import android.app.TabActivity;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;

@SuppressWarnings("deprecation")
public class RoboEventsTabActivityTest extends ActivityEventsTest {

	public RoboEventsTabActivityTest() {
		super(RoboEventsTabActivity.class);
	}

	@Override
	@Before
	public void setUp() throws Exception {
		// We want to skip the real functionality of Activity (even though it's
		// shadowed and just test the firing of events)
		Robolectric.bindShadowClass(ShadowTabActivity.class);
		super.setUp();
	}

	@Implements(TabActivity.class)
	public static class ShadowTabActivity extends
			com.xtremelabs.robolectric.shadows.ShadowTabActivity {

		@Override
		@Implementation
		public void setContentView(int layoutResId) {
		}

	}
}
