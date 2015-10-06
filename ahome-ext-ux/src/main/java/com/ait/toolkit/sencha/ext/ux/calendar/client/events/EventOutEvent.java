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
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class EventOutEvent extends EventObject {

    public static String EVENT_NAME = "eventout";

    private CalendarPanel source;
    private CalendarEvent calenderEvent;
    private Element el;

    /**
     * UiBinder implementations
     */
    private static Type<EventOutHandler> TYPE = new Type<EventOutHandler>( EVENT_NAME, null );

    public static Type<EventOutHandler> getType() {
        return TYPE;
    }

    public static Type<EventOutHandler> getAssociatedType() {
        return TYPE;
    }

    public EventOutEvent( JavaScriptObject jsObj ) {
        super( jsObj );
    }

    public EventOutEvent( CalendarPanel source, CalendarEvent calendarEvent, Element el, JavaScriptObject nativeEvent ) {
        super( nativeEvent );
        this.source = source;
        this.calenderEvent = calendarEvent;
        this.el = el;

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

    public Element getEl() {
        return el;
    }

}
