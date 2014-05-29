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
package com.ait.toolkit.sencha.ext.ux.grid.checkcolumn.client;

import com.ait.toolkit.sencha.ext.client.grid.column.GridColumn;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;

/**
 * A Header subclass which renders a checkbox in each column cell which toggles
 * the truthiness of the associated data field on click.
 * 
 */
public class CheckColumn extends GridColumn {

	public CheckColumn() {
		setXType(XType.CHECK_COLUMN.getValue());
		this.setFlex(1);
	}

	public CheckColumn(String title) {
		this();
		setHeader(title);
	}

	public CheckColumn(String title, String dataIndex) {
		this(title);
		setDataIndex(dataIndex);
	}

	protected CheckColumn(JavaScriptObject obj) {
		super(obj);
	}

	public static CheckColumn cast(GridColumn obj) {
		return new CheckColumn(obj.getJsObj());
	}

	public static void inject() {
		ScriptInjector
				.fromUrl(GWT.getModuleBaseURL() + "checkcolumn/CheckColumn.js")
				.setWindow(ScriptInjector.TOP_WINDOW).inject();
	}

}
