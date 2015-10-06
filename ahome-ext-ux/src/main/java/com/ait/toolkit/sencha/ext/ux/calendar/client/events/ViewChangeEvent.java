/*
 * Copyright (c) 2014 Ahomé Innovation Technologies. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ait.toolkit.sencha.ext.ux.calendar.client.events;

import com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel;
import com.ait.toolkit.sencha.ext.ux.calendar.client.data.ViewInfo;
import com.ait.toolkit.sencha.ext.ux.calendar.client.views.AbstractCalendarView;
import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ViewChangeEvent extends EventObject {

    public static String EVENT_NAME = "viewchange";

    private CalendarPanel source;
    private AbstractCalendarView view;
    private ViewInfo viewInfo;

    /**
     * UiBinder implementations
     */
    private static Type<ViewChangeHandler> TYPE = new Type<ViewChangeHandler>( EVENT_NAME, null );

    public static Type<ViewChangeHandler> getType() {
        return TYPE;
    }

    public static Type<ViewChangeHandler> getAssociatedType() {
        return TYPE;
    }

    public ViewChangeEvent( JavaScriptObject jsObj ) {
        super( jsObj );
    }

    public ViewChangeEvent( CalendarPanel source, AbstractCalendarView view, ViewInfo viewinfo, JavaScriptObject nativeEvent ) {
        super( nativeEvent );
        this.source = source;
        this.view = view;
        this.viewInfo = viewinfo;
    }

    /**
     * @return the source
     */
    public CalendarPanel getPanel() {
        return source;
    }

    public CalendarPanel getSource() {
        return source;
    }

    public AbstractCalendarView getView() {
        return view;
    }

    public ViewInfo getViewInfo() {
        return viewInfo;
    }

}
