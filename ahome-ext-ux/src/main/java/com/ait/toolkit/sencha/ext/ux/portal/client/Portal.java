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
package com.ait.toolkit.sencha.ext.ux.portal.client;

import com.ait.toolkit.sencha.ext.client.dd.DropTargetConfig;
import com.ait.toolkit.sencha.ext.client.events.component.AfterRenderEvent;
import com.ait.toolkit.sencha.ext.client.events.component.AfterRenderHandler;
import com.ait.toolkit.sencha.ext.client.layout.Layout;
import com.ait.toolkit.sencha.ext.client.ui.Panel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;

/**
 * Portal class. A portal is created by instantiating this class, and adding {@link PortalColumn}'s with a specified {@link com.ait.ext4j.client.layout.ColumnLayoutData}.
 * 
 * <br>
 * To each PortalColumn, a Portlet is added.
 */
// credits : this class has been adapted from the Ext portal sample
public class Portal extends Panel {

	static {
		injectPlugin();
	}

	private DropTargetConfig ddConfig;

	public Portal() {
		ddConfig = new DropTargetConfig();
		setLayout(Layout.COLUMN);
		setAutoScroll(true);
		setCls("x-portal");
		this.addAfterRenderHandler(new AfterRenderHandler() {
			@Override
			public void onAfterRender(AfterRenderEvent event) {
				new PortalDropZone(Portal.this, ddConfig);
			}
		});

	}

	private static void injectPlugin() {
		ScriptInjector.fromUrl(GWT.getModuleBaseURL() + "portal/PortalDropZone.js").setWindow(ScriptInjector.TOP_WINDOW).inject();
	}

}
