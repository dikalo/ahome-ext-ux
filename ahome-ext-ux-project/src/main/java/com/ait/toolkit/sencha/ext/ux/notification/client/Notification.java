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
package com.ait.toolkit.sencha.ext.ux.notification.client;

import com.ait.toolkit.sencha.ext.client.ui.Window;
import com.ait.toolkit.sencha.shared.client.fx.Easing;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;

public class Notification extends Window {

	private static JavaScriptObject configPrototype;

	private native Notification init()/*-{
		var c = new $wnd.Ext.ux.window.Notification();
		@com.ait.toolkit.sencha.ext.ux.notification.client.Notification::configPrototype = c.initialConfig;
	}-*/;

	static {
		load();
	}

	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "uxNotification";
	}

	/**
	 * Create a new Notification.
	 */
	public Notification() {

	}

	/**
	 * Construct a new Notification with the given title.
	 * 
	 * @param title
	 *            the title
	 */
	Notification(String title) {
		setTitle(title);
	}

	Notification(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public void setUseXAxis(boolean value) {
		setAttribute("useXAxis", value, true);
	}

	public void setPosition(NotificationPosition position) {
		_setPosition(position.getValue());
	}

	private void _setPosition(String position) {
		setAttribute("position", position, true);
	}

	public void setManager(String position) {
		setAttribute("manager", position, true);
	}

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		//config.manager = 'ahome-ext-ux-not-manager';
		return $wnd.Ext.create('widget.uxNotification', config);
	}-*/;

	public native void slideBack() /*-{
		var notification = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		notification.slideBack();
	}-*/;

	public void setAutoClose(boolean value) {
		setAttribute("autoClose", value, true);
	}

	public void setAutoCloseDelay(int value) {
		setAttribute("autoCloseDelay", value, true);
	}

	public void setAutoHeight(boolean value) {
		setAttribute("autoHeight", value, true);
	}

	public void setHideDuration(int value) {
		setAttribute("hideDuration", value, true);
	}

	public void setPaddingX(int value) {
		setAttribute("paddingX", value, true);
	}

	public void setPaddingY(int value) {
		setAttribute("paddingY", value, true);
	}

	public native void slideBack(String value) /*-{
		var notification = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		notification.slideBack(value);
	}-*/;

	public void setSlideBackAnimation(Easing easing) {
		setSlideBackAnimation(easing.getValue());
	}

	public void setSlideBackAnimation(String value) {
		setAttribute("slideBackAnimation", value, true);
	}

	public void setSlideBackDuration(int value) {
		setAttribute("slideBackDuration", value, true);
	}

	public void setSlideInAnimation(Easing easing) {
		setSlideInAnimation(easing.getValue());
	}

	public void setSlideInAnimation(String value) {
		setAttribute("slideInAnimation", value, true);
	}

	public void setSlideInDuration(int value) {
		setAttribute("slideInDuration", value, true);
	}

	public void setSpacing(int value) {
		setAttribute("spacing", value, true);
	}

	public void setStickOnClick(boolean value) {
		setAttribute("stickOnClick", value, true);
	}

	public void setStickWhileOver(boolean value) {
		setAttribute("stickWhileOver", value, true);
	}

	public void setXPosition(int value) {
		setAttribute("xPosition", value, true);
	}

	public void setYPosition(int value) {
		setAttribute("yPosition", value, true);
	}

	private static void load() {
		NotificationResources resources = GWT.create(NotificationResources.class);
		ScriptInjector.fromString(resources.js().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
	}

}
