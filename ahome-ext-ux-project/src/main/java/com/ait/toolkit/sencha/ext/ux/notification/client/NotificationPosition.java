package com.ait.toolkit.sencha.ext.ux.notification.client;

public enum NotificationPosition {

	TOP("t"), TOP_LEFT("tl"), TOP_RIGHT("tr"), BOTTOM("b"), BOTTOM_LEFT("bl"), BOTTOM_RIGHT(
			"br"), LEFT("l"), RIGHT("r");

	private String pos;

	private NotificationPosition(String position) {
		this.pos = position;
	}

	public String getValue() {
		return this.pos;
	}
}
