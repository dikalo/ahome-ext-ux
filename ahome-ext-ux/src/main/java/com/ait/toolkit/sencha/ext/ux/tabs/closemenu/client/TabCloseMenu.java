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
package com.ait.toolkit.sencha.ext.ux.tabs.closemenu.client;

import java.util.Arrays;
import java.util.List;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.ext.client.grid.plugin.AbstractPlugin;
import com.ait.toolkit.sencha.ext.client.ui.MenuItem;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.ScriptInjector;

public class TabCloseMenu extends AbstractPlugin {

	public TabCloseMenu() {
		jsObj = createNativePeer();
	}

	public void setCloseAllTabsText(String value) {
		JsoHelper.setAttribute(jsObj, "closeAllTabsText", value);
	}

	public void setCloseOthersTabsText(String value) {
		JsoHelper.setAttribute(jsObj, "closeOthersTabsText", value);
	}

	public void setCloseTabText(String value) {
		JsoHelper.setAttribute(jsObj, "closeOtherTabsText", value);
	}

	/**
	 * An array of additional context menu items to add to the front of the
	 * context menu.
	 */
	public void setExtraItemsHead(MenuItem... values) {
		setExtraItemsHead(Arrays.asList(values));
	}

	/**
	 * An array of additional context menu items to add to the front of the
	 * context menu.
	 */
	public void setExtraItemsHead(List<MenuItem> values) {
		JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
		for (MenuItem m : values) {
			jsos.push(m.getJsObj());
		}
		JsoHelper.setAttribute(jsObj, "extraItemsHead", jsos);
	}

	/**
	 * An array of additional context menu items to add to the tail of the
	 * context menu.
	 */
	public void setExtraItemsTail(MenuItem... values) {
		setExtraItemsTail(Arrays.asList(values));
	}

	/**
	 * An array of additional context menu items to add to the tail of the
	 * context menu.
	 */
	public void setExtraItemsTail(List<MenuItem> values) {
		JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
		for (MenuItem m : values) {
			jsos.push(m.getJsObj());
		}
		JsoHelper.setAttribute(jsObj, "extraItemsTail", jsos);
	}

	public void setShowCloseAll(boolean value) {
		JsoHelper.setAttribute(jsObj, "showCloseAll", value);
	}

	public void setShowCloseOthers(boolean value) {
		JsoHelper.setAttribute(jsObj, "showCloseOthers", value);
	}

	public static void inject() {
		ScriptInjector
				.fromUrl(GWT.getModuleBaseURL() + "tabclose/TabCloseMenu.js")
				.setWindow(ScriptInjector.TOP_WINDOW).inject();
	}

	private native JavaScriptObject createNativePeer()/*-{
		return new $wnd.Ext.create('Ext.ux.TabCloseMenu');
	}-*/;
}
