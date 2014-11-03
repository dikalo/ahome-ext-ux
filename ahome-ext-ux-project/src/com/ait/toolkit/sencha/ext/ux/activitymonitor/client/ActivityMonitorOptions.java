package com.ait.toolkit.sencha.ext.ux.activitymonitor.client;

import com.ait.toolkit.core.client.Function;
import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;

public class ActivityMonitorOptions extends JsObject {

	public ActivityMonitorOptions() {
		jsObj = JsoHelper.createObject();
		this.setMouseEvent("mouseover");
	}

	public void setVerbose(boolean value) {
		JsoHelper.setAttribute(jsObj, "verbose", value);
	}

	public void setInterval(int value) {
		JsoHelper.setAttribute(jsObj, "interval", value);
	}

	public void setMaxInactive(int value) {
		JsoHelper.setAttribute(jsObj, "maxInactive", value);
	}

	public void setMouseEvent(String value) {
		JsoHelper.setAttribute(jsObj, "mouseEvent", value);
	}

	public native void setActiveHandler(Function fn)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.isActive = function() {
			fn.@com.ait.toolkit.core.client.Function::execute()();
		};
	}-*/;

	public native void setInactiveHandler(Function fn)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.isInactive = function() {
			fn.@com.ait.toolkit.core.client.Function::execute()();
		};
	}-*/;

}
