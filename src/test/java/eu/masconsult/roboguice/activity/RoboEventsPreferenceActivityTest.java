package eu.masconsult.roboguice.activity;

import org.junit.Before;

import android.preference.PreferenceActivity;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;

public class RoboEventsPreferenceActivityTest extends ActivityEventsTest {

	public RoboEventsPreferenceActivityTest() {
		super(TestActivity.class);
	}

	@Override
	@Before
	public void setUp() throws Exception {
		// We want to skip the real functionality of Activity (even though it's
		// shadowed and just test the firing of events)
		Robolectric.bindShadowClass(ShadowPreferenceActivity.class);
		super.setUp();
	}

	@Implements(PreferenceActivity.class)
	public static class ShadowPreferenceActivity extends
			com.xtremelabs.robolectric.shadows.ShadowPreferenceActivity {

		@Override
		@Implementation
		public void setContentView(int layoutResId) {
		}

	}

	public static class TestActivity extends RoboEventsPreferenceActivity {

	}
}
