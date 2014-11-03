package com.ait.toolkit.sencha.ext.ux.dataview.animated.client;

import com.ait.toolkit.sencha.ext.client.grid.plugin.AbstractViewPlugin;
import com.ait.toolkit.sencha.ext.client.ui.DataView;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.core.shared.GWT;

public class Animated extends AbstractViewPlugin {

	static {
		AnimatedRessources res = GWT.create(AnimatedRessources.class);
		ScriptInjector.fromString(res.js().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
	}

	public Animated(DataView view) {
		this();
		init(view);
	}

	private Animated() {
		jsObj = createNativePeer();
	}

	private native JavaScriptObject createNativePeer()/*-{
		return new $wnd.Ext.ux.DataView.Animated();
	}-*/;

	private native void init(DataView view)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.init(view.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()());
	}-*/;

}
