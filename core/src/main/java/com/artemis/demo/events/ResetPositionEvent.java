package com.artemis.demo.events;

import com.artemis.Entity;
import com.artemis.systems.event.SystemEvent;

public class ResetPositionEvent extends SystemEvent {

    public Entity bouncer;

    @Override
    protected void resetForPooling() {
        bouncer = null;
    }
}
