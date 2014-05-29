/*
 Copyright (c) 2014 Ahomé Innovation Technologies. All rights reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.ait.toolkit.sencha.ext.ux.calendar.client;

import com.ait.toolkit.core.client.CSSUtil;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.ext.client.ui.Panel;
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.user.client.DOM;

public class CalendarPanel extends Panel {

	public CalendarPanel() {

	}

	public CalendarPanel(Store eventStore) {
		this();
		this.setEventStore(eventStore);
	}

	public CalendarPanel(Store eventStore, Store calendarStore) {
		this(eventStore);
		this.setCalendarStore(calendarStore);
	}

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Extensible.calendar.CalendarPanel(config);
	}-*/;

	public void setEventStore(Store store) {
		this.setAttribute("eventStore", store.getJsObj(), true);
	}

	public void setCalendarStore(Store store) {
		this.setAttribute("calendarStore", store.getJsObj(), true);
	}

	public void setStartDay(int value) {
		this.setAttribute("startDay", value, true);
	}

	public String getXType() {
		return "extensible.calendarpanel";
	}

	private static JavaScriptObject calendarScriptElement;
	private static final String CAL_PANEL_JS_ID = "ait-extensible-cal-js-id";
	private static final String CAL_PANEL_CSS_ID = "ait-extensible-cal-csss-id";

	public static void inject() {
		CSSUtil.injectStyleSheet(GWT.getModuleBaseURL()
				+ "extensible/css/extensible-all.css", CAL_PANEL_CSS_ID);
		calendarScriptElement = ScriptInjector
				.fromUrl(
						GWT.getModuleBaseURL() + "extensible/extensible-all.js")
				.setWindow(ScriptInjector.TOP_WINDOW)
				.setCallback(new Callback<Void, Exception>() {
					@Override
					public void onSuccess(Void result) {
						JsoHelper.setAttribute(calendarScriptElement, "id",
								CAL_PANEL_JS_ID);
					}

					@Override
					public void onFailure(Exception reason) {

					}
				}).inject();
	}

	public static void removeRessources() {
		DOM.getElementById(CAL_PANEL_JS_ID).removeFromParent();
		DOM.getElementById(CAL_PANEL_CSS_ID).removeFromParent();
	}

}
