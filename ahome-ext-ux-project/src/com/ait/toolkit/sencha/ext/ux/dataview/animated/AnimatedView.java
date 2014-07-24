package com.ait.toolkit.sencha.ext.ux.dataview.animated;

import com.ait.toolkit.sencha.ext.client.grid.plugin.AbstractViewPlugin;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.core.shared.GWT;

public class AnimatedView extends AbstractViewPlugin {

	static {
		AnimatedViewRessources res = GWT.create(AnimatedViewRessources.class);
		ScriptInjector.fromString(res.js().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
	}

	public AnimatedView() {
		jsObj = createNativePeer();
	}

	private native JavaScriptObject createNativePeer()/*-{
		return new $wnd.Ext.ux.DataView.Animated({
			duration : 550,
			idProperty : 'appLauncher'
		});
	}-*/;

}
