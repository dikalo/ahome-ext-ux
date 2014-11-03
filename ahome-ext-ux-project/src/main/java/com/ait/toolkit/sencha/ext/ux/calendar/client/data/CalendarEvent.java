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

import java.util.Date;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.data.client.BaseModel;

public class CalendarEvent extends BaseModel {

	public CalendarEvent() {
		jsObj = JsoHelper.createObject();
	}

	public void setEventId(int value) {
		this.set("id", value);
	}

	public int getEventId() {
		return JsoHelper.getAttributeAsInt(jsObj, "id");
	}

	public void setCalendarId(int value) {
		this.set("cid", value);
	}

	public int getCalendarId() {
		return JsoHelper.getAttributeAsInt(jsObj, "cid");
	}

	public void setTitle(String value) {
		this.set("title", value);
	}

	public String getTitle() {
		return JsoHelper.getAttribute(jsObj, "title");
	}

	public void setNotes(String value) {
		this.set("notes", value);
	}

	public String getNotes() {
		return JsoHelper.getAttribute(jsObj, "notes");
	}

	public void setStart(Date value) {
		this.set("start", value);
	}

	public void setEnd(Date value) {
		this.set("end", value);
	}

}
