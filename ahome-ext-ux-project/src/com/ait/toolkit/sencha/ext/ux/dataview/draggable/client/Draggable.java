package com.ait.toolkit.sencha.ext.ux.dataview.draggable.client;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.Util;
import com.ait.toolkit.sencha.ext.client.ui.DataView;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.shared.GWT;

public class Draggable extends JsObject {

	private static final DraggableResources resources = GWT.create(DraggableResources.class);

	static {
		Util.injectJs(resources.js());
	}

	public Draggable(DataView view, String ddGroud) {
		this();
		init(view, ddGroud);
	}

	public Draggable(DataView view, String ddGroud, String ghostTemplate) {
		this();
		init(view, ddGroud, ghostTemplate);
	}

	private native void init(DataView view, String g, String tpl)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.init(
						view.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()(),
						{
							ddConfig : {
								ddGroup : g,
								containerScroll : true,
								scroll : true
							},
							ghostTpl : tpl
						});
	}-*/;

	private native void init(DataView view, String g)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.init(
						view.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()(),
						{
							ddConfig : {
								ddGroup : g,
								containerScroll : true,
								scroll : true
							}
						});
	}-*/;

	private Draggable() {
		jsObj = createPeer();
	}

	private native JavaScriptObject createPeer()/*-{
		return new $wnd.Ext.ux.DataView.Draggable();
	}-*/;
}
