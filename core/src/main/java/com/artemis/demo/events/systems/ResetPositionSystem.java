package com.artemis.demo.events.systems;


import com.artemis.ComponentMapper;
import com.artemis.demo.events.ResetPositionEvent;
import com.artemis.demo.events.components.PositionComponent;
import com.artemis.systems.event.EventVoidSystem;
import com.badlogic.gdx.utils.Array;

public class ResetPositionSystem extends EventVoidSystem<ResetPositionEvent> {

    ComponentMapper<PositionComponent> pm;

    Array<ResetPositionEvent> events;

    public ResetPositionSystem() {
        super(ResetPositionEvent.class);
        events = new Array<ResetPositionEvent>();
    }

    @Override
    public void initialize() {
        pm = world.getMapper(PositionComponent.class);
    }

    @Override
    protected void processEvent(ResetPositionEvent event) {
        PositionComponent pc = pm.get(event.bouncer);
        pc.position.set(200, 200);
    }
}
