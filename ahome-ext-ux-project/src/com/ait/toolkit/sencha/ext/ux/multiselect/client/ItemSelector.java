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
package com.ait.toolkit.sencha.ext.ux.multiselect.client;

import com.ait.toolkit.sencha.shared.client.data.Store;
import com.google.gwt.core.client.JavaScriptObject;

public class ItemSelector extends MultiSelect {

	private static JavaScriptObject configPrototype;

	private native void init()/*-{
		//var c = new $wnd.Ext.MultiSelect();
		var c = new $wnd.Ext.ux.form.ItemSelector({});
		@com.ait.toolkit.sencha.ext.ux.multiselect.client.ItemSelector::configPrototype = c.initialConfig;
	}-*/;

	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	@Override
	public String getXType() {
		return "itemselector";
	}

	/**
	 * Create a new Notification.
	 */
	public ItemSelector() {

	}

	public ItemSelector(String fieldLabel) {
		setFieldLabel(fieldLabel);
	}

	public ItemSelector(String fieldLabel, Store store) {
		setFieldLabel(fieldLabel);
		setStore(store);
	}

	public ItemSelector(Store store) {
		setStore(store);
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.form.ItemSelector(config);
	}-*/;

}
