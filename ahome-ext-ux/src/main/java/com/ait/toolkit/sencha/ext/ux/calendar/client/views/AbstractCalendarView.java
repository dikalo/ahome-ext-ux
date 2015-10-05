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
package com.ait.toolkit.sencha.ext.ux.calendar.client.views;

import com.ait.toolkit.sencha.ext.client.core.Component;
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.google.gwt.core.client.JavaScriptObject;

public class AbstractCalendarView extends Component {

    protected AbstractCalendarView() {

    }

    protected AbstractCalendarView( JavaScriptObject obj ) {
        super( obj );
    }

    public AbstractCalendarView( Store eventStore ) {
        this();
        this.setEventStore( eventStore );
    }

    public AbstractCalendarView( Store eventStore, Store calendarStore ) {
        this( eventStore );
        this.setCalendarStore( calendarStore );
    }

    protected native JavaScriptObject create( JavaScriptObject config ) /*-{
		return new $wnd.Extensible.calendar.view.AbstractCalendarPanel(config);
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

    @Override
    protected JavaScriptObject getConfigPrototype() {
        return null;
    }

}
