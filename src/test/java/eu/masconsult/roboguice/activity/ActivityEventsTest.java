package eu.masconsult.roboguice.activity;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import roboguice.RoboGuice;
import roboguice.event.EventManager;
import roboguice.test.RobolectricRoboTestRunner;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.google.inject.Stage;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;

import eu.masconsult.roboguice.activity.event.OnAfterSetContentViewEvent;
import eu.masconsult.roboguice.activity.event.OnBeforeSetContentViewEvent;

@RunWith(RobolectricRoboTestRunner.class)
public class ActivityEventsTest {

	protected Class<? extends Activity> activityClass = RoboEventsActivity.class;
	protected Activity activity;
	protected EventManager mockEventManager;

	@Before
	public void setUp() throws Exception {
		// We want to skip the real functionality of Activity (even though it's
		// shadowed and just test the firing of events)
		Robolectric.bindShadowClass(ShadowActivity.class);

		// Our mock event manager - we'll check on it for fired events
		mockEventManager = mock(EventManager.class);

		// initialize RoboGuice
		RoboGuice.setBaseApplicationInjector(Robolectric.application,
				Stage.DEVELOPMENT,
				RoboGuice.newDefaultRoboModule(Robolectric.application),
				new TestModule(mockEventManager));

		// Our activity under test
		activity = activityClass.newInstance();

		// We need to initialize it
		doOnCreate(null);
	}

	private void doOnCreate(Object object) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Method onCreateMethod = null;

		// Robolectric (probably) does something with the reflection api, and
		// the normal method lookup doesn't search in superclasses so we need to
		// manually traverse the tree
		Class<?> clazz = activityClass;
		do {
			try {
				onCreateMethod = clazz.getDeclaredMethod("onCreate",
						Bundle.class);
			} catch (NoSuchMethodException e) {
				clazz = clazz.getSuperclass();
			}
		} while (onCreateMethod == null);

		// onCreate is protected so we need to make it accessible to us
		onCreateMethod.setAccessible(true);
		onCreateMethod.invoke(activity, (Bundle) null);
	}

	@Test
	public void shouldFireOnBeforeSetContentViewEventForResId() {
		activity.setContentView(-1);
		verify(mockEventManager).fire(isA(OnBeforeSetContentViewEvent.class));
	}

	@Test
	public void shouldFireOnAfterSetContentViewEventForResId() {
		activity.setContentView(-1);
		verify(mockEventManager).fire(isA(OnAfterSetContentViewEvent.class));
	}

	@Test
	public void shouldFireOnBeforeSetContentViewEventForView() {
		activity.setContentView(null);
		verify(mockEventManager).fire(isA(OnBeforeSetContentViewEvent.class));
	}

	@Test
	public void shouldFireOnAfterSetContentViewEventForView() {
		activity.setContentView(null);
		verify(mockEventManager).fire(isA(OnAfterSetContentViewEvent.class));
	}

	@Test
	public void shouldFireOnBeforeSetContentViewEventForViewLayout() {
		activity.setContentView(null, null);
		verify(mockEventManager).fire(isA(OnBeforeSetContentViewEvent.class));
	}

	@Test
	public void shouldFireOnAfterSetContentViewEventForViewLayout() {
		activity.setContentView(null, null);
		verify(mockEventManager).fire(isA(OnAfterSetContentViewEvent.class));
	}

	public static class TestModule extends com.google.inject.AbstractModule {
		private EventManager eventManager;

		public TestModule(EventManager eventManager) {
			this.eventManager = eventManager;
		}

		@Override
		protected void configure() {
			bind(EventManager.class).toInstance(eventManager);
		}
	}

	@Implements(Activity.class)
	public static class ShadowActivity extends
			com.xtremelabs.robolectric.shadows.ShadowActivity {

		@Override
		@Implementation
		public void setContentView(int layoutResId) {
		}

		@Override
		@Implementation
		public void setContentView(View view) {
		}

		@Implementation
		public void setContentView(View view, LayoutParams params) {
		}
	}
}
