package eu.masconsult.roboguice.test;

import org.hamcrest.Factory;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import roboguice.activity.event.OnCreateEvent;
import android.os.Bundle;
import eu.masconsult.roboguice.activity.event.OnPostCreateEvent;
import eu.masconsult.roboguice.activity.event.OnRestoreInstanceStateEvent;
import eu.masconsult.roboguice.activity.event.OnSaveInstanceStateEvent;

public class BundleEventMatcher {

	@Factory
	public static Matcher<OnCreateEvent> createHasBundle(
			Matcher<? super Bundle> matcher) {
		return new FeatureMatcher<OnCreateEvent, Bundle>(matcher,
				"has savedInstanceState", "savedInstanceState") {

			@Override
			protected Bundle featureValueOf(OnCreateEvent actual) {
				return actual.getSavedInstanceState();
			}
		};
	}

	@Factory
	public static Matcher<OnPostCreateEvent> postCreateHasBundle(
			Matcher<? super Bundle> matcher) {
		return new FeatureMatcher<OnPostCreateEvent, Bundle>(matcher,
				"has savedInstanceState", "savedInstanceState") {

			@Override
			protected Bundle featureValueOf(OnPostCreateEvent actual) {
				return actual.getSavedInstanceState();
			}
		};
	}

	@Factory
	public static Matcher<OnSaveInstanceStateEvent> saveInstanceStateHasBundle(
			Matcher<? super Bundle> matcher) {
		return new FeatureMatcher<OnSaveInstanceStateEvent, Bundle>(matcher,
				"has outState", "outState") {

			@Override
			protected Bundle featureValueOf(OnSaveInstanceStateEvent actual) {
				return actual.getOutState();
			}
		};
	}

	@Factory
	public static Matcher<OnRestoreInstanceStateEvent> restoreInstanceStateHasBundle(
			Matcher<? super Bundle> matcher) {
		return new FeatureMatcher<OnRestoreInstanceStateEvent, Bundle>(matcher,
				"has savedInstanceState", "savedInstanceState") {

			@Override
			protected Bundle featureValueOf(OnRestoreInstanceStateEvent actual) {
				return actual.getSavedInstanceState();
			}
		};
	}
}
