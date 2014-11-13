package com.ait.toolkit.sencha.ext.ux.dataview.dragselector.client;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.Util;
import com.ait.toolkit.sencha.ext.client.ui.DataView;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.shared.GWT;

public class DragSelector extends JsObject {

	private static final DragSelectorResources resources = GWT.create(DragSelectorResources.class);

	static {
		Util.injectStyle(resources.css());
		Util.injectJs(resources.js());
	}

	public DragSelector(DataView view) {
		this();
		init(view);
	}

	private DragSelector() {
		jsObj = createPeer();
	}

	private native void init(DataView view)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.init(view.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()());
	}-*/;

	private native JavaScriptObject createPeer()/*-{
		return new $wnd.Ext.ux.DataView.DragSelector();
	}-*/;

}
