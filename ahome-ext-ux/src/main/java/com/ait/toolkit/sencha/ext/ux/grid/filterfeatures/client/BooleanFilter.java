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
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;

/**
 * Boolean filters use unique radio group IDs (so you can have more than one!)
 */
public class BooleanFilter extends Filter {

	public BooleanFilter() {
		jsObj = JsoHelper.createObject();
		setType("boolean");
	}

	/**
	 * Set this to null if you do not want either option to be checked by
	 * default. Defaults to false.
	 */
	public void setDefaultValue(boolean value) {
		JsoHelper.setAttribute(jsObj, "defaultValue", value);
	}

	public void setNoText(String value) {
		JsoHelper.setAttribute(jsObj, "noText", value);
	}

	public void setYesText(String value) {
		JsoHelper.setAttribute(jsObj, "yesText", value);
	}

	public static void inject() {
		ScriptInjector
				.fromUrl(GWT.getModuleBaseURL() + "gridfilter/BooleanFilter.js")
				.setWindow(ScriptInjector.TOP_WINDOW).inject();
	}

}
