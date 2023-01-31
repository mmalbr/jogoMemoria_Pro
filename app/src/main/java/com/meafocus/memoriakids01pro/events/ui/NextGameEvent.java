package com.meafocus.memoriakids01pro.events.ui;

import com.meafocus.memoriakids01pro.events.AbstractEvent;
import com.meafocus.memoriakids01pro.events.EventObserver;

/**
 * When the 'back to menu' was pressed.
 */
public class NextGameEvent extends AbstractEvent {

	public static final String TYPE = NextGameEvent.class.getName();

	@Override
	protected void fire(EventObserver eventObserver) {
		eventObserver.onEvent(this);
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
