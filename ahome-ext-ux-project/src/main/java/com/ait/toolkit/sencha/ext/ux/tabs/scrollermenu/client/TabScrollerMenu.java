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
package com.ait.toolkit.sencha.ext.ux.tabs.scrollermenu.client;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.ext.client.grid.plugin.AbstractPlugin;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;

/**
 * Add a scroller menu to a tabpanel.
 * 
 * @author alainekambi
 * 
 */
public class TabScrollerMenu extends AbstractPlugin {

	public TabScrollerMenu() {
		jsObj = createNativePeer();
	}

	/**
	 * 
	 How long should the title of each Ext.menu.Item be.
	 * <p>
	 * Defaults to: 15
	 */
	public void setMaxText(int value) {
		JsoHelper.setAttribute(jsObj, "maxText", value);
	}

	/**
	 * 
	 Text to prefix the submenus.
	 * <p>
	 * Defaults to: "Items"
	 */
	public void setMenuPrefixText(String value) {
		JsoHelper.setAttribute(jsObj, "menuPrefixText", value);
	}

	/**
	 * 
	 How many items to allow per submenu.
	 * <p>
	 * Defaults to: 10
	 */
	public void setPageSize(int value) {
		JsoHelper.setAttribute(jsObj, "pageSize", value);
	}

	public static void inject() {
		ScriptInjector
				.fromUrl(
						GWT.getModuleBaseURL()
								+ "tabscrollermenu/TabScrollerMenu.js")
				.setWindow(ScriptInjector.TOP_WINDOW).inject();
	}

	private native JavaScriptObject createNativePeer()/*-{
		return $wnd.Ext.create('Ext.ux.TabScrollerMenu');
	}-*/;

}
