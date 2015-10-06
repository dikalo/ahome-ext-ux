package com.ait.toolkit.sencha.ext.ux.calendar.client.data;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.ext.ux.calendar.client.views.AbstractCalendarView;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

public class ViewInfo extends JsObject {

    protected ViewInfo( JavaScriptObject peer ) {
        jsObj = peer;
    }

    public JsDate getActiveDate() {
        return JsoHelper.getAttributeAsJavaScriptObject( jsObj, "activeDate" ).cast();
    }

    public AbstractCalendarView getViewStart() {
        return AbstractCalendarView.cast( JsoHelper.getAttributeAsJavaScriptObject( jsObj, "viewStart" ).cast() );
    }

    public AbstractCalendarView getViewEnd() {
        return AbstractCalendarView.cast( JsoHelper.getAttributeAsJavaScriptObject( jsObj, "viewEnd" ).cast() );
    }
}
