package com.ait.toolkit.sencha.ext.ux.callout.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface CalloutResources extends ClientBundle {

    @Source( "Callout.js" )
    TextResource js();

    @Source( "cartoon.min.css" )
    TextResource cartoonCss();

    @Source( "default.min.css" )
    TextResource defaultCss();

    @Source( "fancy-blue.min.css" )
    TextResource fancyBlueCss();

    @Source( "gray.min.css" )
    TextResource grayCss();

    @Source( "yellow.min.css" )
    TextResource yellowCss();

    @Source( "modern.min.css" )
    TextResource modernCss();
}
