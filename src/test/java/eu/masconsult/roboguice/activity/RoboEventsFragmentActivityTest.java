package eu.masconsult.roboguice.activity;

import org.junit.Before;

import android.support.v4.app.FragmentActivity;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;

public class RoboEventsFragmentActivityTest extends ActivityEventsTest {

	public RoboEventsFragmentActivityTest() {
		super(RoboEventsFragmentActivity.class);
	}

	@Override
	@Before
	public void setUp() throws Exception {
		// We want to skip the real functionality of Activity (even though it's
		// shadowed and just test the firing of events)
		Robolectric.bindShadowClass(ShadowFragmentActivity.class);
		super.setUp();
	}

	@Implements(FragmentActivity.class)
	public static class ShadowFragmentActivity extends
			com.xtremelabs.robolectric.shadows.ShadowFragmentActivity {

		@Override
		@Implementation
		public void setContentView(int layoutResId) {
		}

	}
}
