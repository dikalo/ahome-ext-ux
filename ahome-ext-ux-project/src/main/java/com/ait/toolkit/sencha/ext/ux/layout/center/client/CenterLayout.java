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
package com.ait.toolkit.sencha.ext.ux.layout.center.client;

import com.ait.toolkit.sencha.ext.client.layout.ContainerLayout;
import com.ait.toolkit.sencha.ext.client.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;

/**
 * This layout manager is used to center contents within a container. As a
 * subclass of {@link FitLayout}, CenterLayout expects to have one child item;
 * multiple items will be placed overlapping. The layout does not require any
 * config options. Items in the container can use percentage width or height
 * rather than be fit to the full size of the container.
 */
public class CenterLayout extends FitLayout {

	public CenterLayout() {

	}

	protected CenterLayout(JavaScriptObject obj) {
		super(obj);
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return {
			type : 'ux.center'
		};
	}-*/;

	@Override
	protected native void create() /*-{
		var jso = {
			type : 'ux.center'
		};
		this.@com.ait.toolkit.sencha.ext.client.layout.ContainerLayout::jsObj = jso;
	}-*/;

	public static CenterLayout cast(ContainerLayout layout) {
		return new CenterLayout(layout.getJsObj());
	}

	public static void inject() {
		ScriptInjector
				.fromUrl(
						GWT.getModuleBaseURL() + "centerlayout/centerlayout.js")
				.setWindow(ScriptInjector.TOP_WINDOW).inject();
	}

}
