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
package com.ait.toolkit.sencha.ext.ux.calendar.client;

import com.ait.toolkit.core.client.CSSUtil;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.ext.client.events.HandlerRegistration;
import com.ait.toolkit.sencha.ext.client.ui.Panel;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeDateChangeHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeEventDeleteHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeEventMoveHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeEventResizeHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.DateChangeHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.DayClickHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.DayOutHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.DayOverHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.EditDetailsHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventAddHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventCancelHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventClickHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventMoveHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventOutHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventOverHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventResizeHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventUpdateHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventsRenderedHandler;
import com.ait.toolkit.sencha.ext.ux.calendar.client.events.InitDragHandler;
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.user.client.DOM;

public class CalendarPanel extends Panel {

    private static JavaScriptObject calendarScriptElement;
    private static final String CAL_PANEL_JS_ID = "ait-extensible-cal-js-id";
    private static final String CAL_PANEL_CSS_ID = "ait-extensible-cal-csss-id";

    static {
        inject();
    }

    public CalendarPanel() {

    }

    protected CalendarPanel( JavaScriptObject obj ) {
        super( obj );
    }

    public CalendarPanel( Store eventStore ) {
        this();
        this.setEventStore( eventStore );
    }

    public CalendarPanel( Store eventStore, Store calendarStore ) {
        this( eventStore );
        this.setCalendarStore( calendarStore );
    }

    protected native JavaScriptObject create( JavaScriptObject config ) /*-{
		return new $wnd.Extensible.calendar.CalendarPanel(config);
    }-*/;

    /**
     * The store which is bound to this calendar and contains EventModels.
     *  Note that this is an alias to the default store config (to differentiate that from the optional calendarStore config), and either can be used interchangeably.
     */
    public void setEventStore( Store store ) {
        this.setAttribute( "eventStore", store.getJsObj(), true );
    }

    /**
     * The store which is bound to this calendar and contains CalendarModels.
     *  This is an optional store that provides multi-calendar (and multi-color) support.
     *   If available an additional field for selecting the calendar in which to save an event will be shown in the edit forms. 
     *   If this store is not available then all events will simply use the default calendar (and color).
     */
    public void setCalendarStore( Store store ) {
        this.setAttribute( "calendarStore", store.getJsObj(), true );
    }

    /**
     * The 0-based index within the available views to set as the default active view (defaults to undefined). If not specified the default view will be set as the last one added to the panel. You can retrieve a reference to the active view at any time using the activeView property.
     * @param value
     */
    public void setStartDay( int value ) {
        this.setAttribute( "startDay", value, true );
    }

    /**
     * True to show the default event editor window modally over the entire page, false to allow user interaction with the page while showing the window (the default).
     *  Note that if you replace the default editor window with some alternate component this config will no longer apply.
     */
    public void setEditModal( boolean value ) {
        this.setAttribute( "startDay", value, true );
    }

    /**
     *True to show a link on the event edit window to allow switching to the detailed edit form (the default), false to remove the link and disable detailed event editing.
     */
    public void setEnableEditDetails( boolean value ) {
        this.setAttribute( "enableEditDetails", value, true );
    }

    /**
     * The 0-based index within the available views to set as the default active view (defaults to undefined). If not specified the default view will be set as the last one added to the panel. You can retrieve a reference to the active view at any time using the activeView property.
     * @param value
     */
    public void setActiveItem( int value ) {
        this.setAttribute( "activeItem", value, true );
    }

    /**
     * Text to use for the 'Day' nav bar button.
     */
    public void setDayText( int value ) {
        this.setAttribute( "dayText", value, true );
    }

    /**
     * Text to use for the 'Go' navigation button.
     */
    public void setGoText( int value ) {
        this.setAttribute( "goText", value, true );
    }

    /**
     * Text to use for the 'Jump to:' navigation label.
     */
    public void setJumpToText( int value ) {
        this.setAttribute( "jumpToText", value, true );
    }

    /**
     * Text to use for the 'Month' nav bar button.
     */
    public void setMounthText( int value ) {
        this.setAttribute( "mounthText", value, true );
    }

    /**
     * Deprecated. Please override getMultiDayText instead.
    Text to use for the 'X Days' nav bar button (defaults to "{0} Days" where {0} is automatically replaced by the value of the multDayViewCfg's dayCount value if available, otherwise it uses the view default of 3).
     */
    public void setMultiDayText( int value ) {
        this.setAttribute( "multiDayText", value, true );
    }

    public void setMultiWeekText( int value ) {
        this.setAttribute( "multiWeekText", value, true );
    }

    public void setReadOnly( boolean value ) {
        this.setAttribute( "readOnly", value, true );
    }

    public void setShowDayView( boolean value ) {
        this.setAttribute( "showDayView", value, true );
    }

    public void setShowMounthView( boolean value ) {
        this.setAttribute( "showMounthView", value, true );
    }

    public void setShowMultiDayView( boolean value ) {
        this.setAttribute( "showMultiDayView", value, true );
    }

    public void setShowMultiWeekView( boolean value ) {
        this.setAttribute( "showMultiWeekView", value, true );
    }

    public void setShowNavBar( boolean value ) {
        this.setAttribute( "showNavBar", value, true );
    }

    /**
     * True to display the "Jump to:" label in the calendar panel's navigation header, false to not show it (defaults to true).
     */
    public void setShowNavJump( boolean value ) {
        this.setAttribute( "showNavJump", value, true );
    }

    /**
     * True to display the left/right arrow buttons in the calendar panel's navigation header, false to not show it (defaults to true).
     */
    public void setShowNavNextPrev( boolean value ) {
        this.setAttribute( "showNavNextPrev", value, true );
    }

    /**
     * True to display the "Today" button in the calendar panel's navigation header, false to not show it (defaults to true).
     */
    public void setShowNavToday( boolean value ) {
        this.setAttribute( "showNavToday", value, true );
    }

    /**
     * True to display the current time next to the date in the calendar's current day box, false to not show it (defaults to true).
     */
    public void setShowTime( boolean value ) {
        this.setAttribute( "showTime", value, true );
    }

    /**
     * True to show the value of todayText instead of today's date in the calendar's current day box, false to display the day number(defaults to true).
     */
    public void setShowTodayText( boolean value ) {
        this.setAttribute( "showTodayText", value, true );
    }

    /**
     * True to show the value of todayText instead of today's date in the calendar's current day box, false to display the day number(defaults to true).
     */
    public void setShowWeekView( boolean value ) {
        this.setAttribute( "showWeekView", value, true );
    }

    /**
     * Text to use for the 'Today' nav bar button.
     */
    public void setTodayText( boolean value ) {
        this.setAttribute( "todayText", value, true );
    }

    /**
     * Text to use for the 'Week' nav bar button.
     */
    public void setWeekText( boolean value ) {
        this.setAttribute( "weekText", value, true );
    }

    public String getXType() {
        return "extensible.calendarpanel";
    }

    public native HandlerRegistration addBeforeDateChangeHandler( BeforeDateChangeHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, sd, nd, vs, ve) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeDateChangeEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/google/gwt/core/client/JsDate;Lcom/google/gwt/core/client/JsDate;Lcom/google/gwt/core/client/JsDate;Lcom/google/gwt/core/client/JsDate;Lcom/google/gwt/core/client/JavaScriptObject;)(cp,sd, nd, vs, ve, null);
			return handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeDateChangeHandler::onBeforeDateChange(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/BeforeDateChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeDateChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addBeforeEventDeleteHandler( BeforeEventDeleteHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, r, el) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var rec = @com.ait.toolkit.sencha.ext.ux.calendar.client.data.CalendarEvent::create(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var element = @com.ait.toolkit.sencha.shared.client.dom.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeEventDeleteEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/ait/toolkit/sencha/ext/ux/calendar/client/data/CalendarEvent;Lcom/ait/toolkit/sencha/shared/client/dom/ExtElement;Lcom/google/gwt/core/client/JavaScriptObject;)(cp,rec,element, null);
			return handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeEventDeleteHandler::onBeforeEventDelete(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/BeforeEventDeleteEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeEventDeleteEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addBeforeEventMoveHandler( BeforeEventMoveHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, r) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var rec = @com.ait.toolkit.sencha.ext.ux.calendar.client.data.CalendarEvent::create(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeEventMoveEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/ait/toolkit/sencha/ext/ux/calendar/client/data/CalendarEvent;Lcom/google/gwt/core/client/JavaScriptObject;)(cp,rec,null);
			return handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeEventMoveHandler::onBeforeEventMove(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/BeforeEventMoveEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeEventMoveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addBeforeEventResizeHandler( BeforeEventResizeHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, r) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var rec = @com.ait.toolkit.sencha.ext.ux.calendar.client.data.CalendarEvent::create(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeEventResizeEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/ait/toolkit/sencha/ext/ux/calendar/client/data/CalendarEvent;Lcom/google/gwt/core/client/JavaScriptObject;)(cp,rec,null);
			return handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeEventResizeHandler::onBeforeEventResize(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/BeforeEventResizeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.BeforeEventResizeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addDateChangeHandler( DateChangeHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, sd, vs, ve) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.DateChangeEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/google/gwt/core/client/JsDate;Lcom/google/gwt/core/client/JsDate;Lcom/google/gwt/core/client/JsDate;Lcom/google/gwt/core/client/JavaScriptObject;)(cp,sd, vs, ve ,null);
			handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.DateChangeHandler::onDateChange(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/DateChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.DateChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addDayClickHandler( DayClickHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, dt, allDay, el) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var element = @com.ait.toolkit.sencha.shared.client.dom.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.DayClickEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/google/gwt/core/client/JsDate;ZLcom/ait/toolkit/sencha/shared/client/dom/ExtElement;Lcom/google/gwt/core/client/JavaScriptObject;)(cp,dt, allDay,element, null);
			handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.DayClickHandler::onDayClick(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/DayClickEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.DayClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addDayOutHandler( DayOutHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, dt, el) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var element = @com.ait.toolkit.sencha.shared.client.dom.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.DayOutEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/google/gwt/core/client/JsDate;Lcom/ait/toolkit/sencha/shared/client/dom/ExtElement;Lcom/google/gwt/core/client/JavaScriptObject;)(cp, element,null);
			handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.DayOutHandler::onDayOut(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/DayOutEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.DayOutEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addDayOverHandler( DayOverHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, dt, el) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var element = @com.ait.toolkit.sencha.shared.client.dom.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.DayOverEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/google/gwt/core/client/JsDate;Lcom/ait/toolkit/sencha/shared/client/dom/ExtElement;Lcom/google/gwt/core/client/JavaScriptObject;)(cp, element,null);
			handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.DayOverHandler::onDayOver(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/DayOverEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.DayOverEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addEditDetailsHandler( EditDetailsHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, r, el) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var element = @com.ait.toolkit.sencha.shared.client.dom.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
			var view = @com.ait.toolkit.sencha.ext.ux.calendar.client.views.AbstractCalendarView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var ev = @com.ait.toolkit.sencha.ext.ux.calendar.client.data.CalendarEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);

			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EditDetailsEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/ait/toolkit/sencha/ext/ux/calendar/client/views/AbstractCalendarView;Lcom/ait/toolkit/sencha/ext/ux/calendar/client/data/CalendarEvent;Lcom/ait/toolkit/sencha/shared/client/dom/ExtElement;Lcom/google/gwt/core/client/JavaScriptObject;)(cp,view,ev,element,null);
			handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.EditDetailsHandler::onEditDetails(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/EditDetailsEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EditDetailsEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addEventAddHandler( EventAddHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, r) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var rec = @com.ait.toolkit.sencha.ext.ux.calendar.client.data.CalendarEvent::create(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventAddEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/ait/toolkit/sencha/ext/ux/calendar/client/data/CalendarEvent;Lcom/google/gwt/core/client/JavaScriptObject;)(cp,rec,null);
			return handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventAddHandler::onEventAdd(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/EventAddEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventAddEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addEventCancelHandler( EventCancelHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, r) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var rec = @com.ait.toolkit.sencha.ext.ux.calendar.client.data.CalendarEvent::create(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventCancelEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/ait/toolkit/sencha/ext/ux/calendar/client/data/CalendarEvent;Lcom/google/gwt/core/client/JavaScriptObject;)(cp,rec,null);
			return handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventCancelHandler::onEventCancel(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/EventCancelEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventCancelEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addEventClickHandler( EventClickHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, r, el) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var rec = @com.ait.toolkit.sencha.ext.ux.calendar.client.data.CalendarEvent::create(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventClickEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/ait/toolkit/sencha/ext/ux/calendar/client/data/CalendarEvent;Lcom/google/gwt/dom/client/Element;Lcom/google/gwt/core/client/JavaScriptObject;)(cp,rec,el,null);
			return handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventClickHandler::onEventClick(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/EventClickEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addEventMoveHandler( EventMoveHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, r) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var rec = @com.ait.toolkit.sencha.ext.ux.calendar.client.data.CalendarEvent::create(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventMoveEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/ait/toolkit/sencha/ext/ux/calendar/client/data/CalendarEvent;Lcom/google/gwt/core/client/JavaScriptObject;)(cp,rec,null);
			handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventMoveHandler::onEventMove(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/EventMoveEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventMoveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addEventOutHandler( EventOutHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, r, el) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var rec = @com.ait.toolkit.sencha.ext.ux.calendar.client.data.CalendarEvent::create(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventOutEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/ait/toolkit/sencha/ext/ux/calendar/client/data/CalendarEvent;Lcom/google/gwt/dom/client/Element;Lcom/google/gwt/core/client/JavaScriptObject;)(cp, rec, el, null);
			handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventOutHandler::onEventOut(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/EventOutEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventOutEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addEventOverHandler( EventOverHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, r, el) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var rec = @com.ait.toolkit.sencha.ext.ux.calendar.client.data.CalendarEvent::create(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventOverEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/ait/toolkit/sencha/ext/ux/calendar/client/data/CalendarEvent;Lcom/google/gwt/dom/client/Element;Lcom/google/gwt/core/client/JavaScriptObject;)(cp, rec, el, null);
			handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventOverHandler::onEventOver(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/EventOverEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventOverEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addEventResizeHandler( EventResizeHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, r) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var rec = @com.ait.toolkit.sencha.ext.ux.calendar.client.data.CalendarEvent::create(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventResizeEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/ait/toolkit/sencha/ext/ux/calendar/client/data/CalendarEvent;Lcom/google/gwt/core/client/JavaScriptObject;)(cp,rec,null);
			handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventResizeHandler::onEventResize(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/EventResizeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventResizeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addEventsRenderedHandler( EventsRenderedHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventsRenderedEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/google/gwt/core/client/JavaScriptObject;)(cp,null);
			handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventsRenderedHandler::onEventsRendered(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/EventsRenderedEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventsRenderedEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addInitDragHandler( InitDragHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.InitDragEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/google/gwt/core/client/JavaScriptObject;)(cp,null);
			handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.InitDragHandler::onInitDrag(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/EventsRenderedEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.InitDragEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addEventUpdateHandler( EventUpdateHandler handler )/*-{
		var component = this.@com.ait.toolkit.sencha.ext.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, r) {
			var cp = @com.ait.toolkit.sencha.ext.ux.calendar.client.CalendarPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var rec = @com.ait.toolkit.sencha.ext.ux.calendar.client.data.CalendarEvent::create(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventUpdateEvent::new(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/CalendarPanel;Lcom/ait/toolkit/sencha/ext/ux/calendar/client/data/CalendarEvent;Lcom/google/gwt/core/client/JavaScriptObject;)(cp,rec,null);
			handler.@com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventUpdateHandler::onEventUpdate(Lcom/ait/toolkit/sencha/ext/ux/calendar/client/events/EventUpdateEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.ext.ux.calendar.client.events.EventUpdateEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.ext.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/ext/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public static void inject() {
        CSSUtil.injectStyleSheet( GWT.getModuleBaseURL()
                + "extensible/css/extensible-all.css", CAL_PANEL_CSS_ID );
        calendarScriptElement = ScriptInjector
            .fromUrl(
                GWT.getModuleBaseURL() + "extensible/extensible-all.js" )
            .setWindow( ScriptInjector.TOP_WINDOW )
            .setCallback( new Callback<Void, Exception>() {
                @Override
                public void onSuccess( Void result ) {
                    JsoHelper.setAttribute( calendarScriptElement, "id",
                        CAL_PANEL_JS_ID );
                }

                @Override
                public void onFailure( Exception reason ) {

                }
            } ).inject();
    }

    public static void removeRessources() {
        DOM.getElementById( CAL_PANEL_JS_ID ).removeFromParent();
        DOM.getElementById( CAL_PANEL_CSS_ID ).removeFromParent();
    }

}
