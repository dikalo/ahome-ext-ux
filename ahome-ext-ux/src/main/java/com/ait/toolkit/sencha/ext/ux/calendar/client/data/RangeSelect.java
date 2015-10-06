package com.ait.toolkit.sencha.ext.ux.calendar.client.data;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

public class RangeSelect extends JsObject {

    protected RangeSelect( JavaScriptObject peer ) {
        jsObj = peer;
    }

    public JsDate getStartDate() {
        return JsoHelper.getAttributeAsJavaScriptObject( jsObj, "StartDate" ).cast();
    }

    public JsDate getEndDate() {
        return JsoHelper.getAttributeAsJavaScriptObject( jsObj, "EndDate" ).cast();
    }
}
