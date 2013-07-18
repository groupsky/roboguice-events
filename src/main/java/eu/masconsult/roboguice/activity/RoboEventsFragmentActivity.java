/*
 * Copyright 2013 Geno Roupsky
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package eu.masconsult.roboguice.activity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ViewGroup.LayoutParams;
import eu.masconsult.roboguice.activity.event.OnAfterSetContentViewEvent;
import eu.masconsult.roboguice.activity.event.OnBackPressedEvent;
import eu.masconsult.roboguice.activity.event.OnBeforeSetContentViewEvent;
import eu.masconsult.roboguice.activity.event.OnContextItemSelectedEvent;
import eu.masconsult.roboguice.activity.event.OnContextMenuClosedEvent;
import eu.masconsult.roboguice.activity.event.OnCreateContextMenuEvent;
import eu.masconsult.roboguice.activity.event.OnCreateOptionsMenuEvent;
import eu.masconsult.roboguice.activity.event.OnKeyDownEvent;
import eu.masconsult.roboguice.activity.event.OnKeyLongPressEvent;
import eu.masconsult.roboguice.activity.event.OnKeyMultipleEvent;
import eu.masconsult.roboguice.activity.event.OnKeyShortcutEvent;
import eu.masconsult.roboguice.activity.event.OnKeyUpEvent;
import eu.masconsult.roboguice.activity.event.OnOptionsItemSelectedEvent;
import eu.masconsult.roboguice.activity.event.OnOptionsMenuClosedEvent;
import eu.masconsult.roboguice.activity.event.OnPostCreateEvent;
import eu.masconsult.roboguice.activity.event.OnPostResumeEvent;
import eu.masconsult.roboguice.activity.event.OnPrepareOptionsMenuEvent;
import eu.masconsult.roboguice.activity.event.OnRestoreInstanceStateEvent;
import eu.masconsult.roboguice.activity.event.OnSaveInstanceStateEvent;
import roboguice.activity.RoboFragmentActivity;

public class RoboEventsFragmentActivity extends RoboFragmentActivity {

	@Override
	public void setContentView(int layoutResID) {
		eventManager.fire(new OnBeforeSetContentViewEvent());
		super.setContentView(layoutResID);
		eventManager.fire(new OnAfterSetContentViewEvent());
	}

	@Override
	public void setContentView(View view) {
		eventManager.fire(new OnBeforeSetContentViewEvent());
		super.setContentView(view);
		eventManager.fire(new OnAfterSetContentViewEvent());
	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		eventManager.fire(new OnBeforeSetContentViewEvent());
		super.setContentView(view, params);
		eventManager.fire(new OnAfterSetContentViewEvent());
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		eventManager.fire(new OnPostCreateEvent(savedInstanceState));
	}

	@Override
	protected void onPostResume() {
		super.onPostResume();
		eventManager.fire(new OnPostResumeEvent());
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		eventManager.fire(new OnSaveInstanceStateEvent(outState));
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		eventManager.fire(new OnRestoreInstanceStateEvent(savedInstanceState));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		final OnCreateOptionsMenuEvent e = new OnCreateOptionsMenuEvent(menu);
		eventManager.fire(e);
		return super.onCreateOptionsMenu(menu) || e.isMenuEnabled();
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		final OnPrepareOptionsMenuEvent e = new OnPrepareOptionsMenuEvent(menu);
		eventManager.fire(e);
		return super.onPrepareOptionsMenu(menu) || e.hasMenu();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		final OnOptionsItemSelectedEvent e = new OnOptionsItemSelectedEvent(
				item);
		eventManager.fire(e);
		return e.isHandled() || super.onOptionsItemSelected(item);
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		super.onOptionsMenuClosed(menu);
		eventManager.fire(new OnOptionsMenuClosedEvent(menu));
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		eventManager.fire(new OnCreateContextMenuEvent(menu, v, menuInfo));
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		final OnContextItemSelectedEvent e = new OnContextItemSelectedEvent(
				item);
		eventManager.fire(e);
		return e.isHandled() || super.onContextItemSelected(item);
	}
	
	@Override
	public void onContextMenuClosed(Menu menu) {
		super.onContextMenuClosed(menu);
		eventManager.fire(new OnContextMenuClosedEvent(menu));
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		final OnKeyDownEvent e = new OnKeyDownEvent(keyCode, event);
		eventManager.fire(e);
		return e.isHandled() || super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		final OnKeyUpEvent e = new OnKeyUpEvent(keyCode, event);
		eventManager.fire(e);
		return e.isHandled() || super.onKeyUp(keyCode, event);
	}

	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		final OnKeyLongPressEvent e = new OnKeyLongPressEvent(keyCode, event);
		eventManager.fire(e);
		return e.isHandled() || super.onKeyLongPress(keyCode, event);
	}

	@Override
	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		final OnKeyMultipleEvent e = new OnKeyMultipleEvent(keyCode,
				repeatCount, event);
		eventManager.fire(e);
		return e.isHandled()
				|| super.onKeyMultiple(keyCode, repeatCount, event);
	}

	@Override
	public boolean onKeyShortcut(int keyCode, KeyEvent event) {
		final OnKeyShortcutEvent e = new OnKeyShortcutEvent(keyCode, event);
		eventManager.fire(e);
		return e.isHandled() || super.onKeyShortcut(keyCode, event);
	}

	@Override
	public void onBackPressed() {
		final OnBackPressedEvent e = new OnBackPressedEvent();
		eventManager.fire(e);
		if (!e.isBackCanceled())
			super.onBackPressed();
	}
}
