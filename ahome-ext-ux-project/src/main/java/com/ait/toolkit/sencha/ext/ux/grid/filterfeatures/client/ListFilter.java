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
package com.ait.toolkit.sencha.ext.ux.grid.filterfeatures.client;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.ext.client.grid.column.Filter;
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;

/**
 * List filters are able to be preloaded/backed by an Ext.data.Store to load
 * their options the first time they are shown. ListFilter utilizes the
 * Ext.ux.grid.menu.ListMenu component.
 * <p>
 * Although not shown here, this class accepts all configuration options for
 * Ext.ux.grid.menu.ListMenu.
 * 
 */
public class ListFilter extends Filter {

	public ListFilter() {
		jsObj = JsoHelper.createObject();
		setType("list");
	}

	public void setStore(Store value) {
		JsoHelper.setAttribute(jsObj, "dateFormat", value.getJsObj());
	}

	public void setPhpMode(boolean value) {
		JsoHelper.setAttribute(jsObj, "phpMode", value);
	}

	public void setOptions(JavaScriptObject value) {
		JsoHelper.setAttribute(jsObj, "options", value);
	}

	public static void inject() {
		ScriptInjector
				.fromUrl(GWT.getModuleBaseURL() + "gridfilter/ListFilter.js")
				.setWindow(ScriptInjector.TOP_WINDOW).inject();

		ScriptInjector
				.fromUrl(GWT.getModuleBaseURL() + "gridfilter/ListMenu.js")
				.setWindow(ScriptInjector.TOP_WINDOW).inject();
	}

}
