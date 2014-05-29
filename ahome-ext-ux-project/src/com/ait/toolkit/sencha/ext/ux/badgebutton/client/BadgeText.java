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
package com.ait.toolkit.sencha.ext.ux.badgebutton.client;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.ext.client.grid.plugin.AbstractPlugin;
import com.ait.toolkit.sencha.ext.client.ui.Button;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.user.client.DOM;

public class BadgeText extends AbstractPlugin {

	private static JavaScriptObject scriptElement;
	private static final String BADGE_TEXT_JS_ID = "ait-badgetext-js-id";

	public BadgeText() {
		jsObj = createPeer();
	}

	public void setDisableBgColor(String value) {
		JsoHelper.setAttribute(jsObj, "disableBg", value);
	}

	public void setTextSize(int value) {
		JsoHelper.setAttribute(jsObj, "textSize", value);
	}

	public void setTextColor(String value) {
		JsoHelper.setAttribute(jsObj, "textColor", value);
	}

	public void setDefaultText(String value) {
		JsoHelper.setAttribute(jsObj, "defaultText", value);
	}

	public void setDisableOpacity(int value) {
		JsoHelper.setAttribute(jsObj, "disableOpacity", value);
	}

	public void setAlign(String value) {
		JsoHelper.setAttribute(jsObj, "align", value);
	}

	public void setText(String value) {
		JsoHelper.setAttribute(jsObj, "text", value);
	}

	public void setDisable(boolean value) {
		JsoHelper.setAttribute(jsObj, "disable", value);
	}

	public void setButton(Button value) {
		JsoHelper.setAttribute(jsObj, "buttton", value.getOrCreateJsObj());
	}

	public void setEnableBgColor(String value) {
		JsoHelper.setAttribute(jsObj, "enableBg", value);
	}

	private native JavaScriptObject createPeer()/*-{
												return {
												ptype : 'badgetext'
												};
												}-*/;

	public static void inject() {
		scriptElement = ScriptInjector
				.fromUrl(GWT.getModuleBaseURL() + "badgetext/badgetext.js")
				.setWindow(ScriptInjector.TOP_WINDOW)
				.setCallback(new Callback<Void, Exception>() {
					@Override
					public void onSuccess(Void result) {
						JsoHelper.setAttribute(scriptElement, "id",
								BADGE_TEXT_JS_ID);
					}

					@Override
					public void onFailure(Exception reason) {
						// Error
					}
				}).inject();
	}

	public static void removeRessources() {
		DOM.getElementById(BADGE_TEXT_JS_ID).removeFromParent();
	}

}
