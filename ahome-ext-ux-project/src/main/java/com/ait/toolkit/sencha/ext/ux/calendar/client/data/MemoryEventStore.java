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
package com.ait.toolkit.sencha.ext.ux.calendar.client.data;

import java.util.ArrayList;
import java.util.List;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.data.client.BaseModel;
import com.ait.toolkit.data.client.Bean;
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.google.gwt.core.client.JavaScriptObject;

public class MemoryEventStore extends Store {

	public MemoryEventStore(JavaScriptObject[] storeData) {
		assert storeData.length > 0 : "Store data can not be empty";
		create("", JsoHelper.arrayConvert(storeData));

	}

	public MemoryEventStore(List<? extends BaseModel> data) {
		assert !data.isEmpty() : "BaseModel list cannot be empty.";
		// Set<String> fields = new HashSet<String>(data.get(0).getFields());
		init(data);
	}

	public static MemoryEventStore from(List<? extends Bean> beans) {
		List<BaseModel> models = new ArrayList<BaseModel>();
		for (Bean bean : beans) {
			models.add(BaseModel.from(bean.getJsObj()));
		}
		return new MemoryEventStore(models);
	}

	public void setAutoMsg(boolean value) {
		JsoHelper.setAttribute(jsObj, "autoMsg", value);
	}

	protected void init(List<? extends BaseModel> data) {
		// modelRegistry++;
		// modelName = model + modelRegistry;
		this.elements.addAll(data);

		// ExtCore.defineModel(modelName, fields);
		JavaScriptObject[] storeData = new JavaScriptObject[data.size()];

		for (int i = 0; i < data.size(); i++) {
			storeData[i] = data.get(i).getJsObj();
		}

		create("", JsoHelper.arrayConvert(storeData));
	}

	private native void create(String modelName, JavaScriptObject values)/*-{
		this.@com.ait.toolkit.core.client.JsObject::jsObj = new $wnd.Extensible.calendar.data.MemoryEventStore(
				{
					data : values
				});
	}-*/;

}
