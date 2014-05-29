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
package com.ait.toolkit.sencha.ext.ux.buttonsegment.client;

import com.ait.toolkit.core.client.CSSUtil;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.ext.client.ui.ButtonGroup;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;

public class ButtonSegment extends ButtonGroup {

	private static JavaScriptObject scriptElement;
	private static final String JS_ID = "ait-bs-js-id";
	private static final String CSS_ID = "ait-bs-css-id";

	public String getXType() {
		return "buttonsegment";
	}

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.container.ButtonSegment(config);
	}-*/;

	protected ButtonSegment(JavaScriptObject jsObj) {
		super(jsObj);
	}

	/**
	 * Applys the ButtonSegment to an existing element.
	 * 
	 * @param element
	 *            the element
	 */
	public ButtonSegment(Element element) {
		super(element);
	}

	public ButtonSegment() {

	}

	public static void inject() {
		CSSUtil.injectStyleSheet(GWT.getModuleBaseURL()
				+ "buttonsegment/buttonsegment.css", CSS_ID);
		scriptElement = ScriptInjector
				.fromUrl(
						GWT.getModuleBaseURL()
								+ "buttonsegment/buttonsegment.js")
				.setWindow(ScriptInjector.TOP_WINDOW)
				.setCallback(new Callback<Void, Exception>() {
					@Override
					public void onSuccess(Void result) {
						JsoHelper.setAttribute(scriptElement, "id", JS_ID);
					}

					@Override
					public void onFailure(Exception reason) {
						// Error
					}
				}).inject();
	}

	public static void removeRessources() {
		DOM.getElementById(JS_ID).removeFromParent();
		DOM.getElementById(CSS_ID).removeFromParent();
	}

}
