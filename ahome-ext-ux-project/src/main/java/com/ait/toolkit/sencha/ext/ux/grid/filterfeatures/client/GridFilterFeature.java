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

import com.ait.toolkit.sencha.ext.client.grid.column.Filter;
import com.ait.toolkit.sencha.ext.client.grid.feature.Feature;
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;

/**
 * 
 * GridFilterFeature is a grid feature that allows for a slightly more robust
 * representation of filtering than what is provided by the default store.
 * <p>
 * Filtering is adjusted by the user using the grid's column header menu (this
 * menu can be disabled through configuration). Through this menu users can
 * configure, enable, and disable filters for each column.
 * 
 */
public class GridFilterFeature extends Feature {

	public GridFilterFeature() {
		jsObj = createNativePeer();
	}

	/**
	 * Adds a filter to the collection and observes it for state change.
	 */
	public native void addFilter(Filter filter)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.addFilter(filter.@com.ait.toolkit.core.client.JsObject::getJsObj()());
	}-*/;

	/**
	 * 
	 * Changes the data store bound to this view and refreshes it.
	 */
	public native void bindStore(Store s)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.bindStore(s.@com.ait.toolkit.core.client.JsObject::getJsObj()());
	}-*/;

	/**
	 * 
	 * Remove all filters, permanently destroying them.
	 */
	public native void removeAll()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.removeAll();
	}-*/;

	/**
	 * 
	 Update the styles for the header row based on the active filters
	 */
	public native void updateColumnHeadings()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.updateColumnHeadings();
	}-*/;

	public static void inject() {
		ScriptInjector
				.fromUrl(
						GWT.getModuleBaseURL() + "gridfilter/FilterFeatures.js")
				.setWindow(ScriptInjector.TOP_WINDOW).inject();
	}

	private native JavaScriptObject createNativePeer()/*-{
		var v = new $wnd.Ext.ux.grid.FiltersFeature({
			local : true
		});
		return v;
	}-*/;
}
