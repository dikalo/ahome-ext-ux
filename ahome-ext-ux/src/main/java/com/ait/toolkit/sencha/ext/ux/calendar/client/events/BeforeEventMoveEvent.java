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
import com.ait.toolkit.sencha.ext.ux.calendar.client.data.CalendarEvent;
import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class BeforeEventMoveEvent extends EventObject {

    public static String EVENT_NAME = "beforeeventmove";

    private CalendarPanel source;
    private CalendarEvent calenderEvent;

    /**
     * UiBinder implementations
     */
    private static Type<BeforeEventMoveHandler> TYPE = new Type<BeforeEventMoveHandler>( EVENT_NAME, null );

    public static Type<BeforeEventMoveHandler> getType() {
        return TYPE;
    }

    public static Type<BeforeEventMoveHandler> getAssociatedType() {
        return TYPE;
    }

    public BeforeEventMoveEvent( JavaScriptObject jsObj ) {
        super( jsObj );
    }

    public BeforeEventMoveEvent( CalendarPanel source, CalendarEvent calendarEvent, JavaScriptObject nativeEvent ) {
        super( nativeEvent );
        this.calenderEvent = calendarEvent;

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

    public CalendarEvent getCalenderEvent() {
        return calenderEvent;
    }

}
