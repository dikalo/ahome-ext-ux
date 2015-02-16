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

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.sencha.ext.client.dd.DropTargetConfig;
import com.google.gwt.core.client.JavaScriptObject;

// credits : this class has been adapted from the Ext portal sample
class PortalDropZone extends JsObject {

	public PortalDropZone(Portal portal, DropTargetConfig config) {
		jsObj = createNativePeer(portal.getOrCreateJsObj(), config.getJsObj());

	}

	private native JavaScriptObject createNativePeer(JavaScriptObject portal,
			JavaScriptObject config)/*-{
		return new $wnd.Ext.app.PortalDropZone(portal, config);
	}-*/;

}
