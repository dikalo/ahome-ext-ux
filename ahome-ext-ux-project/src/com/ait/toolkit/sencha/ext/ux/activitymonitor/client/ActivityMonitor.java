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
package com.ait.toolkit.sencha.ext.ux.activitymonitor.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.core.shared.GWT;

public final class ActivityMonitor {

	private static final ActivitiyMonitorResources resources = GWT.create(ActivitiyMonitorResources.class);

	static {
		ScriptInjector.fromString(resources.js().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
	}

	private ActivityMonitor() {

	}

	public static void init(ActivityMonitorOptions options) {
		_init(options.getJsObj());
	}

	private static native void _init(JavaScriptObject config)/*-{
		$wnd.Ext.ux.ActivityMonitor.init(config);
	}-*/;

	public static native void start()/*-{
		$wnd.Ext.ux.ActivityMonitor.start();
	}-*/;

	public static native void stop()/*-{
		$wnd.Ext.ux.ActivityMonitor.start();
	}-*/;

}
