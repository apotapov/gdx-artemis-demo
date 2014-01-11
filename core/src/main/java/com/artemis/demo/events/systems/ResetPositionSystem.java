package com.artemis.demo.events.systems;


import com.artemis.ComponentMapper;
import com.artemis.demo.events.ResetPositionEvent;
import com.artemis.demo.events.components.PositionComponent;
import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.utils.Array;

public class ResetPositionSystem extends VoidEntitySystem {

    ComponentMapper<PositionComponent> pm;

    Array<ResetPositionEvent> events;

    public ResetPositionSystem() {
        events = new Array<ResetPositionEvent>();
    }

    @Override
    public void initialize() {
        pm = world.getMapper(PositionComponent.class);
    }

    @Override
    protected void processSystem() {
        world.getEvents(this, ResetPositionEvent.class, events);
        for (ResetPositionEvent event : events) {
            PositionComponent pc = pm.get(event.bouncer);
            pc.position.set(200, 200);
        }
    }
}
